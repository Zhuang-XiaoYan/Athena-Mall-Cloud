package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2022/10/29 9:16
 * @Created by xjl
 */
@Controller
public class OrderController {

    @GetMapping({"/order", "/order.html"})
    public String orderPage() {
        return "order";
    }
}
