package com.zhuangxiaoyan.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname SearchController
 * @Description TODO
 * @Date 2022/10/29 9:23
 * @Created by xjl
 */
@Controller
public class SearchController {

    @GetMapping({"/search", "/search.html"})
    public String searchPage() {
        return "search";
    }
}
