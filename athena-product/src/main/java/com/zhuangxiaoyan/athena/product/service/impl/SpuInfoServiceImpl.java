package com.zhuangxiaoyan.athena.product.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.constant.ProductConstant;
import com.zhuangxiaoyan.athena.product.dao.SpuInfoDao;
import com.zhuangxiaoyan.athena.product.entity.*;
import com.zhuangxiaoyan.athena.product.fegin.CouponFeginService;
import com.zhuangxiaoyan.athena.product.fegin.WareFeginService;
import com.zhuangxiaoyan.athena.product.service.*;
import com.zhuangxiaoyan.athena.product.to.SkuEsModelTo;
import com.zhuangxiaoyan.athena.product.vo.*;
import com.zhuangxiaoyan.common.to.SkuReductionTo;
import com.zhuangxiaoyan.common.to.SpuBoundTo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import com.zhuangxiaoyan.common.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description SpuInfoServiceImpl
 * @date: 2022/7/28 14:26
 * @author: xjl
 */

@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Autowired
    SpuInfoDescService spuInfoDescService;

    @Autowired
    SpuImagesService spuImagesService;

    @Autowired
    AttrService attrService;

    @Autowired
    ProductAttrValueService productAttrValueService;

    @Autowired
    SkuInfoService skuInfoService;

    @Autowired
    SkuImagesService skuImagesService;

    @Autowired
    SkuSaleAttrValueService skuSaleAttrValueService;

    @Autowired
    CouponFeginService couponFeginService;

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    WareFeginService wareFeginService;

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 14:28
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(new Query<SpuInfoEntity>().getPage(params), new QueryWrapper<SpuInfoEntity>());
        return new PageUtils(page);
    }

    /**
     * @description saveSpuInfo
     * @param: spuSaveVo
     * @date: 2022/7/28 14:28
     * @return: void
     * @author: xjl
     */
    @Transactional(rollbackFor = Exception.class, timeout = 50)
    @Override
    public void saveSpuInfo(SpuSaveVo spuSaveVo) {
        // 1、保存到spu的基本信息 psm_spu_info
        SpuInfoEntity spuInfoEntity = new SpuInfoEntity();
        BeanUtils.copyProperties(spuSaveVo, spuInfoEntity);
        spuInfoEntity.setCreateTime(new Date());
        spuInfoEntity.setUpdateTime(new Date());
        this.saveBaseSpuInfo(spuInfoEntity);
        // 2、保存Spu的描述图片 psm_spu_info_desc
        List<String> decript = spuSaveVo.getDecript();
        SpuInfoDescEntity descEntity = new SpuInfoDescEntity();
        descEntity.setSpuId(spuInfoEntity.getId());
        descEntity.setDecript(String.join(",", decript));
        spuInfoDescService.saveSpuInforDescript(descEntity);
        // 3、保存spu的图片集 psm_spu_images
        List<String> images = spuSaveVo.getImages();
        spuImagesService.saveImages(spuInfoEntity.getId(), images);
        // 4、保存spu的规格参数  psm_product_attr_value
        List<BaseAttrsVo> baseAttrs = spuSaveVo.getBaseAttrs();
        List<ProductAttrValueEntity> collect = baseAttrs.stream().map(attr -> {
            ProductAttrValueEntity productAttrValueEntity = new ProductAttrValueEntity();
            productAttrValueEntity.setAttrId(attr.getAttrId());
            AttrEntity attrId = attrService.getById(attr.getAttrId());
            productAttrValueEntity.setAttrName(attrId.getAttrName());
            productAttrValueEntity.setAttrValue(attr.getAttrValues());
            productAttrValueEntity.setQuickShow(attr.getShowDesc());
            productAttrValueEntity.setSpuId(spuInfoEntity.getId());
            return productAttrValueEntity;
        }).collect(Collectors.toList());
        productAttrValueService.saveProductAttr(collect);
        // 5、保存的spu的积分信息 athena-sms->sms_spu_bounds
        BoundsVo boundvos = spuSaveVo.getBounds();
        SpuBoundTo spuBoundTo = new SpuBoundTo();
        BeanUtils.copyProperties(boundvos, spuBoundTo);
        spuBoundTo.setSpuId(spuInfoEntity.getId());
        Result result = couponFeginService.saveSpuBounds(spuBoundTo);
        if (result.getCode() != 0) {
            log.error("远程保存spu的积分信息失败");
        }
        // 6、保存当前spu对应的所有的sku的信息
        // 6.1  sku的基本信息： pms_sku_info
        List<SkusVo> skus = spuSaveVo.getSkus();
        if (skus != null && skus.size() > 0) {
            skus.forEach(item -> {
                String defaultImg = "";
                for (ImagesVo img : item.getImages()) {
                    if (img.getDefaultImg() == 1) {
                        defaultImg = img.getImgUrl();
                    }
                }
                SkuInfoEntity skuInfoEntity = new SkuInfoEntity();
                BeanUtils.copyProperties(item, skuInfoEntity);
                skuInfoEntity.setBrandId(spuInfoEntity.getBrandId());
                skuInfoEntity.setCatalogId(spuInfoEntity.getCatalogId());
                skuInfoEntity.setSaleCount(0L);
                skuInfoEntity.setSpuId(spuInfoEntity.getId());
                skuInfoEntity.setSkuDefaultImg(defaultImg);
                skuInfoService.saveSkuInfo(skuInfoEntity);
                Long skuId = skuInfoEntity.getSkuId();
                List<SkuImagesEntity> imagesEntities = item.getImages().stream().map(img -> {
                    SkuImagesEntity skuImagesEntity = new SkuImagesEntity();
                    skuImagesEntity.setSkuId(skuId);
                    skuImagesEntity.setImgUrl(img.getImgUrl());
                    skuImagesEntity.setDefaultImg(img.getDefaultImg());
                    return skuImagesEntity;
                }).filter(entity -> {
                    // 返回true就是需要 返回的false 就是剔除
                    return !StringUtils.isEmpty(entity.getImgUrl());
                }).collect(Collectors.toList());
                // 6.2 保存的sku的图片信息 pms_sku_images
                skuImagesService.saveBatch(imagesEntities);
                // 6.3 销售属性的sku信息  pms_sku_sale_attr_value
                List<AttrSubVo> attr = item.getAttr();
                List<SkuSaleAttrValueEntity> skuSaleAttrValueEntities = attr.stream().map(at -> {
                    SkuSaleAttrValueEntity skuSaleAttrValueEntity = new SkuSaleAttrValueEntity();
                    BeanUtils.copyProperties(at, skuSaleAttrValueEntity);
                    skuSaleAttrValueEntity.setSkuId(skuId);
                    return skuSaleAttrValueEntity;
                }).collect(Collectors.toList());
                skuSaleAttrValueService.saveBatch(skuSaleAttrValueEntities);
                // 6.4 sku的优惠满减的等信息 athena-sms-中sms_sku_full_reduction\ sms_member_price
                SkuReductionTo skuReductionTo = new SkuReductionTo();
                BeanUtils.copyProperties(item, skuReductionTo);
                skuReductionTo.setSkuId(skuId);
                if (skuReductionTo.getFullCount() > 0 || skuReductionTo.getFullPrice().compareTo(new BigDecimal("0")) == 1) {
                    Result result1 = couponFeginService.saveSkuReduction(skuReductionTo);
                    if (result.getCode() != 0) {
                        log.error("远程sku的优惠满减信息保存失败");
                    }
                }
            });
        }
    }

    /**
     * @description saveBaseSpuInfo
     * @param: spuInfoEntity
     * @date: 2022/7/28 14:28
     * @return: void
     * @author: xjl
     */
    @Override
    public void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity) {
        this.baseMapper.insert(spuInfoEntity);
    }

    /**
     * @description queryPageByCondition
     * @param: params
     * @date: 2022/7/28 14:29
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPageByCondition(Map<String, Object> params) {
        QueryWrapper<SpuInfoEntity> queryWrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.and(wrapper -> {
                wrapper.eq("id", key).or().like("spu_name", key);
            });
        }
        String status = (String) params.get("status");
        if (!StringUtils.isEmpty(status)) {
            queryWrapper.eq("publish_status", status);
        }

        String brandId = (String) params.get("brandId");
        if (!StringUtils.isEmpty(brandId) && !"0".equalsIgnoreCase(brandId)) {
            queryWrapper.eq("brand_id", brandId);
        }

        String catelogId = (String) params.get("catelogId");
        if (!StringUtils.isEmpty(catelogId) && !"0".equalsIgnoreCase(catelogId)) {
            queryWrapper.eq("catelog_id", catelogId);
        }
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params), queryWrapper
        );
        return new PageUtils(page);
    }

    /**
     * @description 保存数据到es中
     * @param: spuId
     * @date: 2022/8/1 21:04
     * @return: void
     * @author: xjl
     */
    @Override
    public void spusavees(Long spuId) {

        // 查出当前sku的所有可以被用来检索的规格属性
        List<ProductAttrValueEntity> baseAttrs = productAttrValueService.baseAttrListSpu(spuId);

        List<Long> attrIds = baseAttrs.stream().map(attr -> {
            return attr.getAttrId();
        }).collect(Collectors.toList());

        List<Long> searchAttrIds = attrService.selectSearchAttrs(attrIds);

        //转换为Set集合
        Set<Long> idSet = searchAttrIds.stream().collect(Collectors.toSet());

        List<SkuEsModelTo.Attrs> attrsList = baseAttrs.stream().filter(item -> {
            return idSet.contains(item.getAttrId());
        }).map(item -> {
            SkuEsModelTo.Attrs attrs = new SkuEsModelTo.Attrs();
            BeanUtils.copyProperties(item, attrs);
            return attrs;
        }).collect(Collectors.toList());

        // 查询的当前spuid所对应的sku信息品牌的名字
        List<SkuInfoEntity> skuInfoEntities = skuInfoService.getSkusBySpuId(spuId);

        List<Long> skuIdList = skuInfoEntities.stream()
                .map(SkuInfoEntity::getSkuId)
                .collect(Collectors.toList());
        // 发送远程调用，库存系统查询是否有库存
        Map<Long, Boolean> stockMap = null;
        try {
            Result skuHasStock = wareFeginService.getSkuHasStock(skuIdList);
            TypeReference<List<SkuHasStockVo>> typeReference = new TypeReference<List<SkuHasStockVo>>() {};
            stockMap = skuHasStock.getData(typeReference).stream()
                    .collect(Collectors.toMap(SkuHasStockVo::getSkuId, item -> item.getHasStock()));
        } catch (Exception e) {
            log.error("库存服务查询异常：原因{}",e);
        }
        // 封装sku的信息
        Map<Long, Boolean> finalStockMap = stockMap;
        List<SkuEsModelTo> collect = skuInfoEntities.stream().map(sku -> {
            SkuEsModelTo skuEsModelTo = new SkuEsModelTo();
            BeanUtils.copyProperties(sku,skuEsModelTo);
            skuEsModelTo.setSkuPrice(sku.getPrice());
            skuEsModelTo.setSkuImg(sku.getSkuDefaultImg());
            //设置库存信息
            if (finalStockMap == null) {
                skuEsModelTo.setHasStock(true);
            } else {
                skuEsModelTo.setHasStock(finalStockMap.get(sku.getSkuId()));
            }
            // 设置热度评分
            skuEsModelTo.setHotScore(0L);
            // 查询的品牌
            BrandEntity brandEntity = brandService.getById(sku.getBrandId());
            skuEsModelTo.setBrandName(brandEntity.getName());
            skuEsModelTo.setBrandId(brandEntity.getBrandId());
            skuEsModelTo.setBrandImg(brandEntity.getLogo());
            // 分类的名字
            CategoryEntity categoryEntity = categoryService.getById(sku.getCatalogId());
            skuEsModelTo.setCatalogId(categoryEntity.getCatId());
            skuEsModelTo.setCatalogName(categoryEntity.getName());
            // 设置检索属性
            skuEsModelTo.setAttrs(attrsList);
            return skuEsModelTo;
        }).collect(Collectors.toList());

        // 将数据发给es进行保存：gulimall-search

    }
}