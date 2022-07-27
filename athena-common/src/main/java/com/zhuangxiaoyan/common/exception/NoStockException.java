package com.zhuangxiaoyan.common.exception;

import lombok.Data;

/**
 * @description 库存异常枚举类
 * @date: 2022/3/19 18:34
 * @return:
 * @author: xjl
 */

@Data
public class NoStockException extends RuntimeException {

    private Long skuId;

    public NoStockException(Long skuId) {
        super("商品id：" + skuId + "库存不足！");
    }

    public NoStockException(String msg) {
        super(msg);
    }
}
