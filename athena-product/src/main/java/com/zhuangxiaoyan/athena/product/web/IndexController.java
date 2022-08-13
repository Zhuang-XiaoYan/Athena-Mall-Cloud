package com.zhuangxiaoyan.athena.product.web;

import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.athena.product.service.CategoryService;
import com.zhuangxiaoyan.athena.product.vo.Catelog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Description IndexController
 * @Date 2022/8/3 23:04
 * @Created by xjl
 */
@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;

    /**
     * @description 访问前端页面
      * @param: model
     * @date: 2022/8/13 10:19
     * @return: java.lang.String
     * @author: xjl
    */
    @GetMapping({"/", "/index.html"})
    public String indexPage(Model model) {
        // 查询所有的以及分类
        List<CategoryEntity> categoryEntities = categoryService.queryOneCategory();
        // 设置视图解析器
        model.addAttribute("categories", categoryEntities);
        return "index";
    }

    /**
     * @description 访问的是的目录的json数据
      * @param:
     * @date: 2022/8/13 10:19
     * @return: java.util.Map<java.lang.String,java.util.List<com.zhuangxiaoyan.athena.product.vo.Catelog2Vo>>
     * @author: xjl
    */
    @GetMapping(value = "/index/catalog.json")
    @ResponseBody
    public Map<String, List<Catelog2Vo>> getCatalogJson() {
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJson();
        return catalogJson;
    }


    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }



}
