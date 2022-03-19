package com.zhuangxiaoyan.common.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description TODO
 * @param: null
 * @date: 2022/3/19 18:34
 * @return:
 * @author: xjl
 */

@Data
public class SkuReductionTo {

    private Long skuId;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrice;

}
