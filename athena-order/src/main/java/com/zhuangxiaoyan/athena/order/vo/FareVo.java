package com.zhuangxiaoyan.athena.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description TODO
  * @param: null
 * @date: 2022/9/6 9:03
 * @return:
 * @author: xjl
*/
@Data
public class FareVo {

    private MemberAddressVo address;

    private BigDecimal fare;

}
