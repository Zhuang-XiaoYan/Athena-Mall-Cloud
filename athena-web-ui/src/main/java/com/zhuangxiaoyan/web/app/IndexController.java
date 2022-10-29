package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description IndexController首页
  * @param: null
 * @date: 2022/10/29 9:08
 * @return:
 * @author: xjl
*/

@Controller
public class IndexController {

    @GetMapping({"/", "/index", "/index.html"})
    public String indexPage() {
        return "index";
    }

}
