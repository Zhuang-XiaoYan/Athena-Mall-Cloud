package com.zhunagxiaoyan.athena.admin.modules.app.annotation;

import java.lang.annotation.*;

/**
 * @description app登录效验
 * @date: 2022/7/30 9:35
 * @author: xjl
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
