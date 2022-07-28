package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.ProductAttrValueEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description spu属性值接口
 * @date: 2022/7/28 13:39
 * @author: xjl
 */

public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {
    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:48
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description saveProductAttr
     * @param: collect
     * @date: 2022/7/28 13:48
     * @return: void
     * @author: xjl
     */
    void saveProductAttr(List<ProductAttrValueEntity> collect);

    /**
     * @description baseAttrListSpu
     * @param: spuId
     * @date: 2022/7/28 13:48
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.ProductAttrValueEntity>
     * @author: xjl
     */
    List<ProductAttrValueEntity> baseAttrListSpu(Long spuId);

    /**
     * @description updateSpuAttr
     * @param: spuId
     * @param: entities
     * @date: 2022/7/28 13:48
     * @return: void
     * @author: xjl
     */
    void updateSpuAttr(Long spuId, List<ProductAttrValueEntity> entities);
}

