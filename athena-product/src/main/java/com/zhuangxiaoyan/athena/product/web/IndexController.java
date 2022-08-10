package com.zhuangxiaoyan.athena.product.web;

import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.athena.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Description IndexController
 * @Date 2022/8/3 23:04
 * @Created by xjl
 */
@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;

    @GetMapping({"/", "/index.html"})
    public String indexPage(Model model) {
        // 查询所有的以及分类
        List<CategoryEntity> categoryEntities = categoryService.queryOneCategory();
        // 设置视图解析器
        model.addAttribute("categories", categoryEntities);
        return "index";
    }
}
