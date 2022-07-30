package com.zhunagxiaoyan.athena.admin.datasource.annotation;

import java.lang.annotation.*;

/**
 * @description 多数据源注解
 * @date: 2022/7/30 9:33
 * @author: xjl
*/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";
}
