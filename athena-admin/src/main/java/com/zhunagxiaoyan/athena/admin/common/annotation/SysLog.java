/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */
package com.zhunagxiaoyan.athena.admin.common.annotation;

import java.lang.annotation.*;

/**
 * @description 系统日志注解
 * @param: null
 * @date: 2022/3/16 7:45
 * @return:
 * @author: xjl
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
