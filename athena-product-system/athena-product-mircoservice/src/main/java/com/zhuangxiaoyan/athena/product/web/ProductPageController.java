package com.zhuangxiaoyan.athena.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname ProductPageController
 * @Description product的首页的访问类
 * @Date 2022/9/29 23:20
 * @Created by xjl
 */

@Controller
public class ProductPageController {

    @GetMapping({"/", "/product", "/product.html"})
    public String indexPage() {
        return "product";
    }

}
