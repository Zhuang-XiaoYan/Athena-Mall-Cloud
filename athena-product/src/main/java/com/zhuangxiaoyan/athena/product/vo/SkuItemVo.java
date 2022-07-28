package com.zhuangxiaoyan.athena.product.vo;

import com.zhuangxiaoyan.athena.product.entity.SkuImagesEntity;
import com.zhuangxiaoyan.athena.product.entity.SkuInfoEntity;
import com.zhuangxiaoyan.athena.product.entity.SpuInfoDescEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description SkuItemVo
 * @date: 2022/7/28 14:47
 * @author: xjl
*/

@ToString
@Data
public class SkuItemVo {

    /**
     * sku基本信息的获取  pms_sku_info
     */
    private SkuInfoEntity info;

    /**
     * 是否有存储库存
     */
    private boolean hasStock = true;
    /**
     * sku的图片信息    pms_sku_images
     */
    private List<SkuImagesEntity> images;

    /**
     * 获取spu的销售属性组合
     */
    private List<SkuItemSaleAttrVo> saleAttr;

    /**
     * @description 获取spu的介绍
     */
    private SpuInfoDescEntity desc;
    /**
     * @description 获取spu的规格参数信息
     */
    private List<SpuItemAttrGroupVo> groupAttrs;
    /**
     * 秒杀商品的优惠信息
     */
    private SeckillSkuVo seckillSkuVo;

}
