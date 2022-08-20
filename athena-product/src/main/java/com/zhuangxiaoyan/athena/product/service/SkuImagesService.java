package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.SkuImagesEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description sku图片接口
 * @date: 2022/7/28 8:26
 * @author: xjl
 */

public interface SkuImagesService extends IService<SkuImagesEntity> {
    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:49
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * @description 通过的skuid获取商品的sku图片信息
      * @param: skuId
     * @date: 2022/8/20 15:53
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.SkuImagesEntity>
     * @author: xjl
    */
    List<SkuImagesEntity> getImagesBySkuId(Long skuId);
}

