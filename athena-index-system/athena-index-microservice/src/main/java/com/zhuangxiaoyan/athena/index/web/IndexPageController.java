package com.zhuangxiaoyan.athena.index.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname IndexPageController
 * @Description index的首页的访问类
 * @Date 2022/9/29 23:20
 * @Created by xjl
 */

@Controller
public class IndexPageController {

    @GetMapping({"/", "/index","/index.html"})
    public String indexPage() {
        return "index";
    }

}
