package com.zhuangxiaoyan.athena.search.web;

import com.zhuangxiaoyan.athena.search.serivce.AthenaSearchService;
import com.zhuangxiaoyan.athena.search.vo.SearchParamVo;
import com.zhuangxiaoyan.athena.search.vo.SearchResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description SearchController
 * @Date 2022/8/15 21:27
 * @Created by xjl
 */

@Controller
public class SearchController {

    @Autowired
    AthenaSearchService athenaSearchService;


    @GetMapping({"/list.html"})
    public String searchPage() {
        return "list";
    }
}
