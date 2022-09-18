package com.zhuangxiaoyan.athena.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname PageTestController
 * @Description 页面的跳转测试
 * @Date 2022/9/5 21:37
 *@author: xjl
 */
@Controller
public class PageTestController {

    @GetMapping("/{page}.html")
    public String payPage(@PathVariable("page") String page) {
        return page;
    }

}
