package com.zhuangxiaoyan.athena.ware.to;

import lombok.Data;

import java.util.List;

/**
 * @Classname SkuWareHasStockTo
 * @Description TODO
 * @Date 2022/9/12 10:27
 * @Created by xjl
 */

@Data
public class SkuWareHasStockTo {

    private Long skuId;

    private Integer num;

    private List<Long> wareId;

}
