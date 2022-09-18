package com.zhuangxiaoyan.athena.sso.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2022/8/28 16:12
 *@author: xjl
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello service clinet1";
    }

}
