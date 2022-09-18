package com.zhuangxiaoyan.athena.order.vo;

import lombok.Data;

import java.util.List;

/**
 * @description TODO
 * @param: null
 * @date: 2022/9/6 9:03
 * @return:
 * @author: xjl
 */
@Data
public class WareSkuLockVo {

    /**
     * 订单信息
     **/
    private String orderSn;

    /**
     * 需要锁住的所有库存信息
     **/
    private List<OrderItemVo> locks;

}
