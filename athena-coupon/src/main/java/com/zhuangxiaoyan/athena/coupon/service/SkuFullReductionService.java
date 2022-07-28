package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.SkuFullReductionEntity;
import com.zhuangxiaoyan.common.to.SkuReductionTo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 商品满减信息
 * @date: 2022/7/28 16:34
 * @author: xjl
*/
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:34
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description 保存sku关联属性
      * @param: skuReductionTo
     * @date: 2022/7/28 16:34
     * @return: void
     * @author: xjl
    */
    void saveSkuReduction(SkuReductionTo skuReductionTo);
}

