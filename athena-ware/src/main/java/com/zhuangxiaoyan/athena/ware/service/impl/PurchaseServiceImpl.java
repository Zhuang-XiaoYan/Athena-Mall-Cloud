package com.zhuangxiaoyan.athena.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.ware.dao.PurchaseDao;
import com.zhuangxiaoyan.athena.ware.entity.PurchaseDetailEntity;
import com.zhuangxiaoyan.athena.ware.entity.PurchaseEntity;
import com.zhuangxiaoyan.athena.ware.service.PurchaseDetailService;
import com.zhuangxiaoyan.athena.ware.service.PurchaseService;
import com.zhuangxiaoyan.athena.ware.service.WareSkuService;
import com.zhuangxiaoyan.athena.ware.vo.MergeVo;
import com.zhuangxiaoyan.athena.ware.vo.PurchaseDoneVo;
import com.zhuangxiaoyan.athena.ware.vo.PurchaseItemDoneVo;
import com.zhuangxiaoyan.common.constant.WareConstant;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("purchaseService")
public class PurchaseServiceImpl extends ServiceImpl<PurchaseDao, PurchaseEntity> implements PurchaseService {

    @Autowired
    PurchaseDetailService purchaseDetailService;

    @Autowired
    WareSkuService wareSkuService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PurchaseEntity> page = this.page(
                new Query<PurchaseEntity>().getPage(params),
                new QueryWrapper<PurchaseEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageUnrecaive(Map<String, Object> params) {
        IPage<PurchaseEntity> page = this.page(
                new Query<PurchaseEntity>().getPage(params),
                new QueryWrapper<PurchaseEntity>().eq("status", 0).or().eq("status", 1)
        );
        return new PageUtils(page);
    }

    /**
     * @description 合并工单
     * @param: mergeVo
     * @date: 2022/7/27 0:00
     * @return: void
     * @author: xjl
     */
    @Transactional
    @Override
    public void merge(MergeVo mergeVo) {
        Long purchaseId = mergeVo.getPurchaseId();
        if (purchaseId == null) {
            // 新建一个
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            purchaseEntity.setStatus(WareConstant.PurchaseStatusEnum.CREATED.getCode());
            purchaseEntity.setCreateTime(new Date());
            purchaseEntity.setUpdateTime(new Date());
            this.save(purchaseEntity);
            Long purchaseid = purchaseEntity.getId();
        }

        // TODO 确认采购单的的状态是0 或者是1 才是可以进行的采购单的合并工作
        if (mergeVo.getPurchaseId()==WareConstant.PurchaseStatusEnum.CREATED.getCode()||mergeVo.getPurchaseId()==WareConstant.PurchaseStatusEnum.ASSIGNED.getCode()){
            List<Long> items = mergeVo.getItems();
            List<PurchaseDetailEntity> collect = items.stream().map(it -> {
                PurchaseDetailEntity detailEntity = new PurchaseDetailEntity();
                detailEntity.setId(it);
                detailEntity.setPurchaseId(purchaseId);
                detailEntity.setStatus(WareConstant.PurchaseStatusEnum.ASSIGNED.getCode());
                return detailEntity;
            }).collect(Collectors.toList());
            purchaseDetailService.updateBatchById(collect);
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            purchaseEntity.setId(purchaseId);
            purchaseEntity.setUpdateTime(new Date());
            this.updateById(purchaseEntity);
        }
    }

    /**
     * @description 领取的采购单
     * @param: ids
     * @date: 2022/7/27 7:45
     * @return: void
     * @author: xjl
     */
    @Override
    public void received(List<Long> ids) {
        // 确认当前采购单是新建还是的已分配
        List<PurchaseEntity> collect = ids.stream().map(id -> {
            PurchaseEntity byId = this.getById(id);
            return byId;
        }).filter(item -> {
            if (item.getStatus() == WareConstant.PurchaseStatusEnum.CREATED.getCode() || item.getStatus() == WareConstant.PurchaseStatusEnum.ASSIGNED.getCode()) {
                return true;
            } else {
                return false;
            }
        }).map(item -> {
            item.setStatus(WareConstant.PurchaseStatusEnum.RECEIVE.getCode());
            item.setUpdateTime(new Date());
            return item;
        }).collect(Collectors.toList());
        // 改变采购单的状态
        this.updateBatchById(collect);
        // 改变采购项状态
        collect.forEach((item) -> {
            List<PurchaseDetailEntity> purchaseDetailEntities = purchaseDetailService.listDEtailByPurchaseId(item.getId());
            List<PurchaseDetailEntity> updatDetailEntities = purchaseDetailEntities.stream().map(entity -> {
                PurchaseDetailEntity detailEntity = new PurchaseDetailEntity();
                detailEntity.setId(entity.getId());
                detailEntity.setStatus(WareConstant.PurchaseDetailStatusEnum.BUYING.getCode());
                return detailEntity;
            }).collect(Collectors.toList());
            purchaseDetailService.updateBatchById(updatDetailEntities);
        });
    }

    /**
     * @description 完成的采购的需求
      * @param: purchaseDoneVo
     * @date: 2022/7/27 8:15
     * @return: void
     * @author: xjl
    */
    @Transactional
    @Override
    public void done(PurchaseDoneVo purchaseDoneVo) {
        Long id = purchaseDoneVo.getId();

        // 改变采购向的状态
        Boolean flag=true;
        List<PurchaseItemDoneVo> items = purchaseDoneVo.getItems();
        List<PurchaseDetailEntity> updates=new ArrayList<>();
        for (PurchaseItemDoneVo item:items){
            PurchaseDetailEntity detailEntity = new PurchaseDetailEntity();
            if (item.getStatus()==WareConstant.PurchaseDetailStatusEnum.HASERROR.getCode()){
                flag=false;
                detailEntity.setStatus(item.getStatus());
            }else {
                // 将成功的采购进行入库
                detailEntity.setStatus(WareConstant.PurchaseDetailStatusEnum.FINISH.getCode());
                PurchaseDetailEntity entity = purchaseDetailService.getById(item.getItemId());
                wareSkuService.addStock(entity.getSkuId(),entity.getWareId(),entity.getSkuNum());
            }
            detailEntity.setId(item.getItemId());
            updates.add(detailEntity);
        }
        purchaseDetailService.updateBatchById(updates);
        // 改变的采购单的状态
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setId(id);
        purchaseEntity.setStatus(flag?WareConstant.PurchaseStatusEnum.FINISH.getCode():WareConstant.PurchaseStatusEnum.HASERROR.getCode());
        purchaseEntity.setUpdateTime(new Date());
        this.updateById(purchaseEntity);
    }
}