package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2022/10/29 9:15
 * @Created by xjl
 */

@Controller
public class LoginController {

    @GetMapping({"/login", "/login.html"})
    public String loginPage() {
        return "login";
    }
}
