package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname ErrorController
 * @Description TODO
 * @Date 2022/10/29 9:24
 * @Created by xjl
 */
@Controller
public class ErrorController {

    @GetMapping({"/404", "/404.html"})
    public String ErrorPage() {
        return "404";
    }
}
