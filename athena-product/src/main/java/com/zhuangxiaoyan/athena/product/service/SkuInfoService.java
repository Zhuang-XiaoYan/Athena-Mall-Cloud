package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.SkuInfoEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description sku信息接口
 * @date: 2022/7/28 8:27
 * @return:
 * @author: xjl
 */

public interface SkuInfoService extends IService<SkuInfoEntity> {
    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:49
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description saveSkuInfo
     * @param: skuInfoEntity
     * @date: 2022/7/28 13:49
     * @return: void
     * @author: xjl
     */
    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

    /**
     * @description queryPageByCondition
     * @param: params
     * @date: 2022/7/28 13:49
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPageByCondition(Map<String, Object> params);

    /**
     * @description 通过的spuid的查询sku的信息
     * @param: spuId
     * @date: 2022/8/1 21:16
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.SkuInfoEntity>
     * @author: xjl
     */
    List<SkuInfoEntity> getSkusBySpuId(Long spuId);
}

