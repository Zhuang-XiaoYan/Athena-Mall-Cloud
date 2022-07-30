package com.zhuangxiaoyan.athena.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @description WareSkuLockVo
 * @date: 2022/7/31 0:07
 * @author: xjl
 */

@Data
public class WareSkuLockVo {

    private String orderSn;

    /**
     * 需要锁住的所有库存信息
     **/
    private List<OrderItemVo> locks;
}
