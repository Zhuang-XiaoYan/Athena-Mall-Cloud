package com.zhuangxiaoyan.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @description 无库存抛出的异常
 * @param: null
 * @date: 2022/3/19 18:34
 * @return:
 * @author: xjl
 */
public class NoStockException extends RuntimeException {

    @Getter
    @Setter
    private Long skuId;

    public NoStockException(Long skuId) {
        super("商品id：" + skuId + "库存不足！");
    }

    public NoStockException(String msg) {
        super(msg);
    }
}
