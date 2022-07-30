package com.zhuangxiaoyan.athena.ware.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description OrderItemVo
 * @date: 2022/7/31 0:06
 * @author: xjl
 */

@Data
public class OrderItemVo {

    private Long skuId;

    private Boolean check;

    private String title;

    private String image;

    /**
     * 商品套餐属性
     */
    private List<String> skuAttrValues;

    private BigDecimal price;

    private Integer count;

    private BigDecimal totalPrice;

    /**
     * 商品重量
     **/
    private BigDecimal weight = new BigDecimal("0.085");
}
