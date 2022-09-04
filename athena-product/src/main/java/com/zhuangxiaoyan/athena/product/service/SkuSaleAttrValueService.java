package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.SkuSaleAttrValueEntity;
import com.zhuangxiaoyan.athena.product.vo.SkuItemSaleAttrVo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
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

    /**
     * @description 获取spu的销售属性组合
      * @param: spuId
     * @date: 2022/8/20 16:30
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.vo.SkuItemSaleAttrVo>
     * @author: xjl
    */
    List<SkuItemSaleAttrVo> getSaleAttrBySpuId(Long spuId);

    /**
     * @description 通过的这个的来是查询的属性
      * @param: s
     * @date: 2022/9/3 14:04
     * @return: java.util.List<java.lang.String>
     * @author: xjl
    */
    List<String> getSkuSaleAttrValuesStringList(Long skuId);
}

