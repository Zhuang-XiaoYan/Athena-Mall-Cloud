package com.zhunagxiaoyan.athena.admin.common.annotation;

import java.lang.annotation.*;

/**
 * @description 系统日志注解
 * @date: 2022/3/16 7:45
 * @author: xjl
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
