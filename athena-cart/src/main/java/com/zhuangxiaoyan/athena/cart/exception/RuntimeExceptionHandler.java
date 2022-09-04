package com.zhuangxiaoyan.athena.cart.exception;


import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description 统一异常处理
  * @param: null
 * @date: 2022/9/3 12:55
 * @return:
 * @author: xjl
*/

@ControllerAdvice
public class RuntimeExceptionHandler {

    /**
     * 全局统一异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result handler(RuntimeException exception) {
        return Result.error(exception.getMessage());
    }


    @ExceptionHandler(CartExceptionHandler.class)
    public Result userHandler(CartExceptionHandler exception) {
        return Result.error("购物车无此商品");
    }
}
