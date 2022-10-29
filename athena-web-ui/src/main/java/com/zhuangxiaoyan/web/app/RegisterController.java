package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname RegisterController
 * @Description TODO
 * @Date 2022/10/29 9:21
 * @Created by xjl
 */
@Controller
public class RegisterController {

    @GetMapping({"/register", "/register.html"})
    public String registerPage() {
        return "register";
    }
}
