package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname OrdersubmitController
 * @Description TODO
 * @Date 2022/10/29 9:20
 * @Created by xjl
 */
@Controller
public class OrdersubmitController {

    @GetMapping({"/ordersubmit", "/ordersubmit.html"})
    public String productPage() {
        return "ordersubmit";
    }
}
