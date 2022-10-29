package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname orderconfirmController
 * @Description TODO
 * @Date 2022/10/29 9:17
 * @Created by xjl
 */
@Controller
public class OrderconfirmController {

    @GetMapping({"/orderconfirm", "/orderconfirm.html"})
    public String orderconfirmPage() {
        return "orderconfirm";
    }
}
