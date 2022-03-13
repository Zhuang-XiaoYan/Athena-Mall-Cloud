package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.athena.product.service.CategoryService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.R;
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
     * @description TODO 查询出所有的分类以及子分类，以及树形结构
      * @param:
     * @date: 2022/3/13 17:35
     * @return: com.zhuangxiaoyan.common.utils.R
     * @author: xjl
    */
    @RequestMapping("/list/tree")
    public R list() {
        List<CategoryEntity> entities=categoryService.listWithTree();
        return R.ok().put("date", entities);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:category:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category) {
        categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category) {
        categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds) {
        categoryService.removeByIds(Arrays.asList(catIds));
        return R.ok();
    }
}