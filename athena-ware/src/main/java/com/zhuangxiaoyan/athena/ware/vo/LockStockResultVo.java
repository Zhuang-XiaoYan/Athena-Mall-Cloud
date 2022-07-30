package com.zhuangxiaoyan.athena.ware.vo;

import lombok.Data;

/**
 * @description LockStockResultVo
 * @date: 2022/7/31 0:06
 * @author: xjl
 */

@Data
public class LockStockResultVo {

    private Long skuId;

    private Integer num;

    /**
     * 是否锁定成功
     **/
    private Boolean locked;

}
