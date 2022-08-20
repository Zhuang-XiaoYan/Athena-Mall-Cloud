package com.zhuangxiaoyan.athena.product.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.SkuInfoDao;
import com.zhuangxiaoyan.athena.product.entity.SkuImagesEntity;
import com.zhuangxiaoyan.athena.product.entity.SkuInfoEntity;
import com.zhuangxiaoyan.athena.product.entity.SpuInfoDescEntity;
import com.zhuangxiaoyan.athena.product.service.*;
import com.zhuangxiaoyan.athena.product.vo.SeckillSkuVo;
import com.zhuangxiaoyan.athena.product.vo.SkuItemSaleAttrVo;
import com.zhuangxiaoyan.athena.product.vo.SkuItemVo;
import com.zhuangxiaoyan.athena.product.vo.SpuItemAttrGroupVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description SkuInfoServiceImpl
 * @date: 2022/7/28 14:23
 * @author: xjl
 */

@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    @Autowired
    private SkuImagesService skuImagesService;

    @Autowired
    private SpuInfoDescService spuInfoDescService;

    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

//    @Autowired
//    private ThreadPoolExecutor executor;

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 14:20
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(new Query<SkuInfoEntity>().getPage(params), new QueryWrapper<SkuInfoEntity>());
        return new PageUtils(page);
    }

    /**
     * @description saveSkuInfo
     * @param: skuInfoEntity
     * @date: 2022/7/28 14:20
     * @return: void
     * @author: xjl
     */
    @Override
    public void saveSkuInfo(SkuInfoEntity skuInfoEntity) {
        this.baseMapper.insert(skuInfoEntity);
    }

    /**
     * @description queryPageByCondition
     * @param: params
     * @date: 2022/7/28 14:21
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPageByCondition(Map<String, Object> params) {
        QueryWrapper<SkuInfoEntity> queryWrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.and((wrapper) -> {
                wrapper.eq("sku_id", key).or().like("sku_name", key);
            });
        }
        String catelogId = (String) params.get("catelogId");
        if (!StringUtils.isEmpty(catelogId) && !"0".equalsIgnoreCase(catelogId)) {
            queryWrapper.eq("catelog_id", catelogId);
        }
        String brandId = (String) params.get("brandId");
        if (!StringUtils.isEmpty(brandId) && !"0".equalsIgnoreCase(brandId)) {
            queryWrapper.eq("brand_id", brandId);
        }
        String min = (String) params.get("min");
        if (!StringUtils.isEmpty(min) && !"0".equalsIgnoreCase(catelogId)) {
            queryWrapper.ge("price", min);
        }
        String max = (String) params.get("max");
        if (!StringUtils.isEmpty(max)) {
            try {
                BigDecimal bigDecimal = new BigDecimal(max);
                if (bigDecimal.compareTo(new BigDecimal("0")) == 1) {
                    queryWrapper.le("price", max);
                }
            } catch (Exception e) {
            }
        }
        IPage<SkuInfoEntity> page = this.page(new Query<SkuInfoEntity>().getPage(params), queryWrapper);
        return new PageUtils(page);
    }

    /**
     * @description 通过的spuid的查询sku的信息
     * @param: spuId
     * @date: 2022/8/1 21:17
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.SkuInfoEntity>
     * @author: xjl
     */
    @Override
    public List<SkuInfoEntity> getSkusBySpuId(Long spuId) {
        List<SkuInfoEntity> list = this.list(new QueryWrapper<SkuInfoEntity>().eq("spu_id", spuId));
        return list;
    }

    /**
     * @description 展示当前sku的详情页面
      * @param: skuId
     * @date: 2022/8/20 0:10
     * @return: com.zhuangxiaoyan.athena.product.vo.SkuItemVo
     * @author: xjl
    */
    @Override
    public SkuItemVo itemPage(Long skuId) throws ExecutionException, InterruptedException {
        // 穿件返回的结果
        SkuItemVo skuItemVo = new SkuItemVo();

//        CompletableFuture<SkuInfoEntity> infoFuture = CompletableFuture.supplyAsync(() -> {
//            //1、sku基本信息的获取  pms_sku_info
//            SkuInfoEntity info = this.getById(skuId);
//            skuItemVo.setInfo(info);
//            return info;
//        }, executor);
//
//        CompletableFuture<Void> saleAttrFuture = infoFuture.thenAcceptAsync((res) -> {
//            //3、获取spu的销售属性组合
//            List<SkuItemSaleAttrVo> saleAttrVos = skuSaleAttrValueService.getSaleAttrBySpuId(res.getSpuId());
//            skuItemVo.setSaleAttr(saleAttrVos);
//        }, executor);
//
//        CompletableFuture<Void> descFuture = infoFuture.thenAcceptAsync((res) -> {
//            //4、获取spu的介绍    pms_spu_info_desc
//            SpuInfoDescEntity spuInfoDescEntity = spuInfoDescService.getById(res.getSpuId());
//            skuItemVo.setDesc(spuInfoDescEntity);
//        }, executor);
//
//        CompletableFuture<Void> baseAttrFuture = infoFuture.thenAcceptAsync((res) -> {
//            //5、获取spu的规格参数信息
//            List<SpuItemAttrGroupVo> attrGroupVos = attrGroupService.getAttrGroupWithAttrsBySpuId(res.getSpuId(), res.getCatalogId());
//            skuItemVo.setGroupAttrs(attrGroupVos);
//        }, executor);
//
//        // Long spuId = info.getSpuId();
//        // Long catalogId = info.getCatalogId();
//        //2、sku的图片信息    pms_sku_images
//        CompletableFuture<Void> imageFuture = CompletableFuture.runAsync(() -> {
//            List<SkuImagesEntity> imagesEntities = skuImagesService.getImagesBySkuId(skuId);
//            skuItemVo.setImages(imagesEntities);
//        }, executor);
//
//        //等到所有任务都完成
//        CompletableFuture.allOf(saleAttrFuture,descFuture,baseAttrFuture,imageFuture).get();
        return skuItemVo;
    }
}