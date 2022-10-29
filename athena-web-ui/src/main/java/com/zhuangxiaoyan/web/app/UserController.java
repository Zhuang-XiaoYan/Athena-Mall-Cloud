package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2022/10/29 9:22
 * @Created by xjl
 */
@Controller
public class UserController {

    @GetMapping({"/user", "/user.html"})
    public String userPage() {
        return "user";
    }
}
