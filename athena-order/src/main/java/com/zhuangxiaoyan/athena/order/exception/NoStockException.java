package com.zhuangxiaoyan.athena.order.exception;

import lombok.Data;

/**
 * @description 自定义的库存异常类
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
