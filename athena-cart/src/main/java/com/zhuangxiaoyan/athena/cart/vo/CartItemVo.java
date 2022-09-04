package com.zhuangxiaoyan.athena.cart.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description 购物项内容
 * @date: 2022/9/3 7:24
 * @author: xjl
*/

@Data
public class CartItemVo {

    private Long skuId;

    private Boolean check = true;

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
     * 计算当前购物项总价
     */
    public BigDecimal getTotalPrice() {
        return this.price.multiply(new BigDecimal("" + this.count));
    }
}
