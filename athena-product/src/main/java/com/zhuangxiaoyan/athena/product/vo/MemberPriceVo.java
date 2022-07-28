/**
 * Copyright 2020 bejson.com
 */
package com.zhuangxiaoyan.athena.product.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description TODO
 * @date: 2022/7/28 14:47
 * @author: xjl
*/

@Data
public class MemberPriceVo {

    private Long id;

    private String name;

    private BigDecimal price;

}
