package com.zhuangxiaoyan.athena.ware.vo;

import lombok.Data;

/**
 * @description PurchaseItemDoneVo
 * @date: 2022/7/31 0:07
 * @author: xjl
 */

@Data
public class PurchaseItemDoneVo {

    private Long itemId;

    private Integer status;

    private String reason;

}
