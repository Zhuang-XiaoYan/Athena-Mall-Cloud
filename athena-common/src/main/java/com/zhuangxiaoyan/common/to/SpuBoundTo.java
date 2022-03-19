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
public class SpuBoundTo {

    private Long spuId;

    private BigDecimal buyBounds;

    private BigDecimal growBounds;

}
