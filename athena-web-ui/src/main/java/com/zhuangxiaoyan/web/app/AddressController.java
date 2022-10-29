package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname AddressController
 * @Description TODO
 * @Date 2022/10/29 9:10
 * @Created by xjl
 */
@Controller
public class AddressController {

    @GetMapping({"/address", "/address.html"})
    public String addressPage() {
        return "address";
    }
}
