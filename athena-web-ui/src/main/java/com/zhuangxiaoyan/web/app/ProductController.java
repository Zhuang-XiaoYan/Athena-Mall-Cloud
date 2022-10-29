package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname ProductController
 * @Description TODO
 * @Date 2022/10/29 9:13
 * @Created by xjl
 */
@Controller
public class ProductController {

    @GetMapping({"/product", "/product.html"})
    public String productPage() {
        return "product";
    }
}
