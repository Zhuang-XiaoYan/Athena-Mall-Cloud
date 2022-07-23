package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.athena.product.service.CategoryService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * @description 查询出所有的分类以及子分类，以及树形结构
     * @param:
     * @date: 2022/3/13 17:35
     * @return: com.zhuangxiaoyan.common.utils.R
     * @author: xjl
     */
    @RequestMapping("/list/tree")
    public Result list() {
        List<CategoryEntity> entities = categoryService.listWithTree();
        return Result.ok().put("data", entities);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:category:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = categoryService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public Result info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);
        return Result.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public Result save(@RequestBody CategoryEntity category) {
        categoryService.save(category);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public Result update(@RequestBody CategoryEntity category) {
        categoryService.updateCascade(category);
        return Result.ok();
    }

    /**
     * 删除
     * @RequestBody 获取请求数据 必须是发送的是post请求
     * Springmvc 自动的请求的数据的json 转为对应的对象
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public Result delete(@RequestBody Long[] catIds) {
        // 检查删除的菜单 是否被其他的地方引用
        categoryService.removeByIds(Arrays.asList(catIds));
        categoryService.removeMenuByIds(Arrays.asList(catIds));
        return Result.ok();
    }
}