/**
 * Copyright 2020 bejson.com
 */
package com.zhuangxiaoyan.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description TODO
 * @param: null
 * @date: 2022/3/19 18:34
 * @return:
 * @author: xjl
 */

@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;
}
