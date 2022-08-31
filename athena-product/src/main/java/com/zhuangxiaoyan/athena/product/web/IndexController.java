package com.zhuangxiaoyan.athena.product.web;

import com.zhuangxiaoyan.athena.product.constant.ProductConstant;
import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.athena.product.service.CategoryService;
import com.zhuangxiaoyan.athena.product.vo.Catelog2Vo;
import com.zhuangxiaoyan.common.vo.MemberRespVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Description IndexController
 * @Date 2022/8/3 23:04
 * @Created by xjl
 */
@Slf4j
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
    public String indexPage(Model model, HttpSession session) {
        // 查询所有的以及分类
        List<CategoryEntity> categoryEntities = categoryService.queryOneCategory();
        // 设置视图解析器
        model.addAttribute("categories", categoryEntities);
        return "index";
    }

    /**
     * @description 访问Db是的目录的json数据
     * @param:
     * @date: 2022/8/13 10:19
     * @return: java.util.Map<java.lang.String, java.util.List < com.zhuangxiaoyan.athena.product.vo.Catelog2Vo>>
     * @author: xjl
     */
    @ResponseBody
    @GetMapping(value = "/index/FromDb")
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromDb() {
        log.info("从数据中查询数据……");
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJsonFromDb();
        return catalogJson;
    }

    /**
     * @description 访问Db是的目录的json数据
     * @param:
     * @date: 2022/8/13 10:19
     * @return: java.util.Map<java.lang.String, java.util.List < com.zhuangxiaoyan.athena.product.vo.Catelog2Vo>>
     * @author: xjl
     */
    @ResponseBody
    @GetMapping(value = "/Test/FromRedis")
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromRedis() {
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJsonFromRedis();
        return catalogJson;
    }

    /**
     * @description 访问Db是的目录的json数据
     * @param:
     * @date: 2022/8/13 10:19
     * @return: java.util.Map<java.lang.String, java.util.List < com.zhuangxiaoyan.athena.product.vo.Catelog2Vo>>
     * @author: xjl
     */
    @ResponseBody
    @GetMapping(value = "/Test/FromRedisLock")
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromRedisLock() {
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJsonFromDbWithRedisLock();
        return catalogJson;
    }

    /**
     * @description 访问Db是的目录的json数据
     * @param:
     * @date: 2022/8/13 10:19
     * @return: java.util.Map<java.lang.String, java.util.List < com.zhuangxiaoyan.athena.product.vo.Catelog2Vo>>
     * @author: xjl
     */
    @ResponseBody
    @GetMapping(value = "/Test/FromRedissonLock")
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromRedissonLock() {
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJsonFromDbWithRedissonLock();
        return catalogJson;
    }
}