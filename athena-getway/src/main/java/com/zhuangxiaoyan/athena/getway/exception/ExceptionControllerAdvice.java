package com.zhuangxiaoyan.athena.getway.exception;

import com.zhuangxiaoyan.common.exception.ExceptionCode;
import com.zhuangxiaoyan.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 集中处理所有异常
 * @date: 2022/7/28 13:17
 * @author: xjl
 */

@Slf4j
@RestControllerAdvice(basePackages = "com.zhuangxiaoyan.athena.getway")
public class ExceptionControllerAdvice {

    /**
     * @description 参数非法（效验参数）异常 MethodArgumentNotValidException
     * @param: e
     * @date: 2022/7/28 13:17
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleValidException(MethodArgumentNotValidException e) {
        log.error("数据效验出现问题{},异常类型{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return Result.error(ExceptionCode.VAILD_EXCEPTION.getCode(), ExceptionCode.VAILD_EXCEPTION.getMessage())
                .put("data", errMap);
    }

    /**
     * @description handleException
     * @param: throwable
     * @date: 2022/7/28 13:17
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @ExceptionHandler(value = Throwable.class)
    public Result handleException(Throwable throwable) {
        log.error("错误异常{}", throwable);
        return Result.error(ExceptionCode.UNKNOW_EXCEPTION.getCode(), ExceptionCode.UNKNOW_EXCEPTION.getMessage());
    }
}
