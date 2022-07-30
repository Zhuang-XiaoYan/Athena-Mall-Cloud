package com.zhuangxiaoyan.athena.ware.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description FareVo
 * @date: 2022/7/31 0:06
 * @author: xjl
 */

@Data
public class FareVo {

    private MemberAddressVo address;

    private BigDecimal fare;

}


