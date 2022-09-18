package com.zhuangxiaoyan.athena.ware.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.ware.dao.WareSkuDao;
import com.zhuangxiaoyan.athena.ware.entity.WareOrderTaskDetailEntity;
import com.zhuangxiaoyan.athena.ware.entity.WareOrderTaskEntity;
import com.zhuangxiaoyan.athena.ware.entity.WareSkuEntity;
import com.zhuangxiaoyan.athena.ware.exception.NoStockException;
import com.zhuangxiaoyan.athena.ware.fegin.OrderFeignService;
import com.zhuangxiaoyan.athena.ware.fegin.ProductFeginService;
import com.zhuangxiaoyan.athena.ware.service.WareOrderTaskDetailService;
import com.zhuangxiaoyan.athena.ware.service.WareOrderTaskService;
import com.zhuangxiaoyan.athena.ware.service.WareSkuService;
import com.zhuangxiaoyan.athena.ware.to.OrderTo;
import com.zhuangxiaoyan.athena.ware.to.SkuWareHasStockTo;
import com.zhuangxiaoyan.athena.ware.to.StockDetailTo;
import com.zhuangxiaoyan.athena.ware.to.StockLockedTo;
import com.zhuangxiaoyan.athena.ware.vo.OrderItemVo;
import com.zhuangxiaoyan.athena.ware.vo.OrderVo;
import com.zhuangxiaoyan.athena.ware.vo.SkuHasStockVo;
import com.zhuangxiaoyan.athena.ware.vo.WareSkuLockVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import com.zhuangxiaoyan.common.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description WareSkuServiceImpl
 * @date: 2022/7/31 0:02
 * @author: xjl
 */
@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {

    @Autowired
    WareSkuDao wareSkuDao;

    @Autowired
    ProductFeginService productFeginService;

    @Autowired
    WareOrderTaskService wareOrderTaskService;

    @Autowired
    WareOrderTaskDetailService wareOrderTaskDetailService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    OrderFeignService orderFeignService;

    /**
     * @description 页查询
     * @param: params
     * @date: 2022/8/2 8:02
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<WareSkuEntity> queryWrapper = new QueryWrapper<>();
        String skuId = (String) params.get("skuId");
        if (!StringUtils.isEmpty(skuId)) {
            queryWrapper.eq("sku_id", skuId);
        }
        String wareId = (String) params.get("wareId");
        if (!StringUtils.isEmpty(wareId)) {
            queryWrapper.eq("sku_id", wareId);
        }
        IPage<WareSkuEntity> page = this.page(new Query<WareSkuEntity>().getPage(params), queryWrapper);
        return new PageUtils(page);
    }

    /**
     * @description 添加库存
     * @param: skuId
     * @param: wareId
     * @param: skuNum
     * @date: 2022/8/2 8:02
     * @return: void
     * @author: xjl
     */
    @Override
    public void addStock(Long skuId, Long wareId, Integer skuNum) {
        // 判断还没有这个库存记录
        List<WareSkuEntity> entities = wareSkuDao.selectList(new QueryWrapper<WareSkuEntity>().eq("sku_id", skuId).eq("ware_id", wareId));
        if (entities == null || entities.size() == 0) {
            WareSkuEntity wareSkuEntity = new WareSkuEntity();
            wareSkuEntity.setSkuId(skuId);
            wareSkuEntity.setWareId(wareId);
            wareSkuEntity.setStock(skuNum);
            wareSkuEntity.setStockLocked(0);
            // TODO 调用远程服务查询的相关的名字 如果失败了,那也不需要是事务回滚
            try {
                Result info = productFeginService.info(skuId);
                Map<String, Object> map = (Map<String, Object>) info.get("skuInfo");
                if (info.getCode() == 0) {
                    wareSkuEntity.setSkuName((String) map.get("skuName"));
                }
            } catch (Exception e) {

            }
            wareSkuDao.insert(wareSkuEntity);
        } else {
            wareSkuDao.addStock(skuId, wareId, skuNum);
        }
    }

    /**
     * @description 查询是否有库存
     * @param: skuIds
     * @date: 2022/8/1 22:57
     * @return: java.util.List<com.zhuangxiaoyan.athena.ware.vo.SkuHasStockVo>
     * @author: xjl
     */
    @Override
    public List<SkuHasStockVo> querySkuHasStock(List<Long> skuIds) {
        List<SkuHasStockVo> collect = skuIds.stream().map(skuId -> {
            SkuHasStockVo vo = new SkuHasStockVo();
            Long count = baseMapper.querySkuHasStock(skuId);
            vo.setSkuId(skuId);
            vo.setHasStock(count == null ? false : count > 0);
            return vo;
        }).collect(Collectors.toList());
        return collect;
    }

    /**
     * @description 通过订单锁住库存数据
     * 下单成功订单 订单过期没有支付被系统自动取消，被用户手动取消 都是需要解锁库存
     * 下订单成功，库存锁定成功，接下来的业务调用失败，导致订单回滚，之前的锁定的库存的就要自动解锁。
     * @param: vo
     * @date: 2022/9/11 17:24
     * @return: java.util.List<com.zhuangxiaoyan.athena.ware.vo.LockStockResultVo>
     * @author: xjl
     */
    @Transactional(rollbackFor = NoStockException.class)
    @Override
    public Boolean orderLockStock(WareSkuLockVo vo) {
        // 保存库存工作单详情信息
        WareOrderTaskEntity wareOrderTaskEntity = new WareOrderTaskEntity();
        wareOrderTaskEntity.setOrderSn(vo.getOrderSn());
        wareOrderTaskEntity.setCreateTime(new Date());
        wareOrderTaskService.save(wareOrderTaskEntity);
        //1、按照下单的收货地址，找到一个就近仓库，锁定库存
        //2、找到每个商品在哪个仓库都有库存
        List<OrderItemVo> locks = vo.getLocks();
        List<SkuWareHasStockTo> collect = locks.stream().map((item) -> {
            SkuWareHasStockTo stock = new SkuWareHasStockTo();
            Long skuId = item.getSkuId();
            stock.setSkuId(skuId);
            stock.setNum(item.getCount());
            //查询这个商品在哪个仓库有库存
            List<Long> wareIdList = wareSkuDao.listWareIdHasSkuStock(skuId);
            stock.setWareId(wareIdList);
            return stock;
        }).collect(Collectors.toList());
        //2、锁定库存
        for (SkuWareHasStockTo hasStock : collect) {
            boolean skuStocked = false;
            Long skuId = hasStock.getSkuId();
            List<Long> wareIds = hasStock.getWareId();
            if (wareIds == null || wareIds.size() == 0) {
                //没有任何仓库有这个商品的库存
                throw new NoStockException(skuId);
            }
            //1、如果每一个商品都锁定成功,将当前商品锁定了几件的工作单记录发给MQ
            //2、锁定失败。前面保存的工作单信息都回滚了。发送出去的消息，即使要解锁库存，由于在数据库查不到指定的id，所有就不用解锁
            for (Long wareId : wareIds) {
                //锁定成功就返回1，失败就返回0
                Long count = wareSkuDao.lockSkuStock(skuId, wareId, hasStock.getNum());
                if (count == 1) {
                    skuStocked = true;
                    WareOrderTaskDetailEntity taskDetailEntity = new WareOrderTaskDetailEntity();
                    taskDetailEntity.setSkuId(skuId);
                    taskDetailEntity.setSkuNum(hasStock.getNum());
                    taskDetailEntity.setTaskId(wareOrderTaskEntity.getId());
                    taskDetailEntity.setWareId(wareId);
                    taskDetailEntity.setLockStatus(1);
                    wareOrderTaskDetailService.save(taskDetailEntity);
                    //TODO 告诉MQ库存锁定成功
                    StockLockedTo lockedTo = new StockLockedTo();
                    lockedTo.setId(wareOrderTaskEntity.getId());
                    StockDetailTo detailTo = new StockDetailTo();
                    BeanUtils.copyProperties(taskDetailEntity, detailTo);
                    lockedTo.setDetailTo(detailTo);
                    rabbitTemplate.convertAndSend("stock-event-exchange", "stock.locked", lockedTo);
                    break;
                } else {
                    //当前仓库锁失败，重试下一个仓库
                }
            }
            if (skuStocked == false) {
                //当前商品所有仓库都没有锁住
                throw new NoStockException(skuId);
            }
        }
        //3、肯定全部都是锁定成功的
        return true;
    }

    /**
     * 解锁
     * 1、查询数据库关于这个订单锁定库存信息
     * 有：证明库存锁定成功了
     * 解锁：订单状况
     * 1、没有这个订单，必须解锁库存
     * 2、有这个订单，不一定解锁库存
     * 订单状态：已取消：解锁库存
     * 已支付：不能解锁库存
     */
    @Override
    public void unlockStock(StockLockedTo to) {
        //库存工作单的id
        StockDetailTo detail = to.getDetailTo();
        Long detailId = detail.getId();
        WareOrderTaskDetailEntity taskDetailInfo = wareOrderTaskDetailService.getById(detailId);
        if (taskDetailInfo != null) {
            //查出wms_ware_order_task工作单的信息
            Long id = to.getId();
            WareOrderTaskEntity orderTaskInfo = wareOrderTaskService.getById(id);
            //获取订单号查询订单状态
            String orderSn = orderTaskInfo.getOrderSn();
            //远程查询订单信息
            Result orderData = orderFeignService.getOrderStatus(orderSn);
            if (orderData.getCode() == 0) {
                //订单数据返回成功
                OrderVo orderInfo = orderData.getData("data", new TypeReference<OrderVo>() {
                });
                //判断订单状态是否已取消或者支付或者订单不存在
                if (orderInfo == null || orderInfo.getStatus() == 4) {
                    //订单已被取消，才能解锁库存
                    if (taskDetailInfo.getLockStatus() == 1) {
                        //当前库存工作单详情状态1，已锁定，但是未解锁才可以解锁
                        //库存解锁
                        wareSkuDao.unLockStock(detail.getSkuId(), detail.getWareId(), detail.getSkuNum());
                        //更新工作单的状态
                        WareOrderTaskDetailEntity taskDetailEntity = new WareOrderTaskDetailEntity();
                        taskDetailEntity.setId(detailId);
                        //变为已解锁
                        taskDetailEntity.setLockStatus(2);
                        wareOrderTaskDetailService.updateById(taskDetailEntity);
                    }
                }
            } else {
                //远程调用服务失败,消息拒绝以后重新放在队列里面，让别人继续消费解锁
                throw new RuntimeException("远程调用服务失败");
            }
        }
        //无需解锁
    }

    /**
     * 防止订单服务卡顿，导致订单状态消息一直改不了，库存优先到期，
     * 查订单状态新建，什么都不处理,导致卡顿的订单，永远都不能解锁库存
     *
     * @date: 2022/9/18 9:50
     * @return: void
     * @author: xjl
     */
    @Override
    public void unockOrderStock(OrderTo orderTo) {
        String orderSn = orderTo.getOrderSn();
        //查一下最新的库存解锁状态，防止重复解锁库存
        WareOrderTaskEntity orderTaskEntity = wareOrderTaskService.getOrderTaskByOrderSn(orderSn);
        //按照工作单的id找到所有 没有解锁的库存，进行解锁
        Long id = orderTaskEntity.getId();
        List<WareOrderTaskDetailEntity> list = wareOrderTaskDetailService.list(new QueryWrapper<WareOrderTaskDetailEntity>()
                .eq("task_id", id).eq("lock_status", 1));
        for (WareOrderTaskDetailEntity taskDetailEntity : list) {
            //库存解锁
            wareSkuDao.unLockStock(taskDetailEntity.getSkuId(), taskDetailEntity.getWareId(), taskDetailEntity.getSkuNum());
            //更新工作单的状态
            WareOrderTaskDetailEntity taskDetail = new WareOrderTaskDetailEntity();
            taskDetail.setId(taskDetailEntity.getId());
            //变为已解锁
            taskDetail.setLockStatus(2);
            wareOrderTaskDetailService.updateById(taskDetail);
        }
    }
}