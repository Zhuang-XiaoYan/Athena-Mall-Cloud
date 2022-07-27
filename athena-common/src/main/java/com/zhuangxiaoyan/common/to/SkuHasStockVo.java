package com.zhuangxiaoyan.common.to;

import lombok.Data;

/**
 * @description SkuHasStockVo传输对象
 * @param: null
 * @date: 2022/3/19 18:34
 * @return:
 * @author: xjl
 */

@Data
public class SkuHasStockVo {

    /**
     * skuId
     */
    private Long skuId;

    /**
     * hasStock
     */
    private Boolean hasStock;

}
