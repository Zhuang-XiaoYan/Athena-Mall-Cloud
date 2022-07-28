package com.zhuangxiaoyan.common.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description SkuReductionTo传输对象
 * @date: 2022/3/19 18:34
 * @author: xjl
 */

@Data
public class SkuReductionTo {

    /**
     * skuId
     */
    private Long skuId;

    /**
     * fullCount
     */
    private int fullCount;

    /**
     * discount
     */
    private BigDecimal discount;

    /**
     * countStatus
     */
    private int countStatus;

    /**
     * fullPrice
     */
    private BigDecimal fullPrice;

    /**
     * reducePrice
     */
    private BigDecimal reducePrice;

    /**
     * priceStatus
     */
    private int priceStatus;

    /**
     * memberPrice
     */
    private List<MemberPrice> memberPrice;

}
