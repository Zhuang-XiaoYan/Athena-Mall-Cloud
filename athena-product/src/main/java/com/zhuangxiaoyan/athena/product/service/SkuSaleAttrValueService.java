package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.SkuSaleAttrValueEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description sku销售属性&值接口
 * @date: 2022/7/28 8:27
 * @return:
 * @author: xjl
 */

public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {
    /**
     * @description queryPage()
     * @param: params
     * @date: 2022/7/28 13:50
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);
}

