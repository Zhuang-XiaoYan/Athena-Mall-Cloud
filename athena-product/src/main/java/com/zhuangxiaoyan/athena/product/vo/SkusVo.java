/**
 * Copyright 2020 bejson.com
 */
package com.zhuangxiaoyan.athena.product.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description SkusVo
 * @date: 2022/7/28 14:47
 * @author: xjl
*/
@Data
public class SkusVo {

    private List<AttrSubVo> attr;

    private String skuName;

    private BigDecimal price;

    private String skuTitle;

    private String skuSubtitle;

    private List<ImagesVo> images;

    private List<String> descar;

    private int fullCount;

    private BigDecimal discount;

    private int countStatus;

    private BigDecimal fullPrice;

    private BigDecimal reducePrice;

    private int priceStatus;

    private List<MemberPriceVo> memberPrice;

}
