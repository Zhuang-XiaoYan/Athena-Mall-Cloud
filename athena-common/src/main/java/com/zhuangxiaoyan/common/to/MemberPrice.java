/**
 * Copyright 2020 bejson.com
 */
package com.zhuangxiaoyan.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description 会员的价格对象
 * @date: 2022/3/19 18:34
 * @author: xjl
 */

@Data
public class MemberPrice {

    /**
     * id
     */
    private Long id;

    /**
     * name
     */
    private String name;

    /**
     * price
     */
    private BigDecimal price;
}
