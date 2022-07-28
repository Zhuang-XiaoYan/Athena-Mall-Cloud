package com.zhuangxiaoyan.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description SpuBoundTo传输对象
 * @date: 2022/3/19 18:34
 * @author: xjl
 */

@Data
public class SpuBoundTo {

    /**
     * spuId
     */
    private Long spuId;

    /**
     * buyBounds
     */
    private BigDecimal buyBounds;

    /**
     * growBounds
     */
    private BigDecimal growBounds;

}
