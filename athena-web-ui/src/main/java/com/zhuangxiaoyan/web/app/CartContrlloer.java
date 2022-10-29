package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname CartContrlloer
 * @Description TODO
 * @Date 2022/10/29 9:11
 * @Created by xjl
 */
@Controller
public class CartContrlloer {

    @GetMapping({"/cart", "/cart.html"})
    public String cartPage() {
        return "cart";
    }
}
