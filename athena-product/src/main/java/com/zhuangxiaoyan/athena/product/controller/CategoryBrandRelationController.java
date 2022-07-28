package com.zhuangxiaoyan.athena.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuangxiaoyan.athena.product.entity.BrandEntity;
import com.zhuangxiaoyan.athena.product.entity.CategoryBrandRelationEntity;
import com.zhuangxiaoyan.athena.product.service.CategoryBrandRelationService;
import com.zhuangxiaoyan.athena.product.vo.BrandVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description 品牌分类关联
 * @date: 2022/7/28 12:15
 * @return:
 * @author: xjl
 */

@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * @description 查询的
     * @param:
     * @date: 2022/7/25 12:31
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @GetMapping("/brands/list")
    public Result releationBrandRelation(@RequestParam(value = "catId", required = true) Long catId) {
        List<BrandEntity> brandVos = categoryBrandRelationService.getBrandsBycatId(catId);
        List<BrandVo> collectBrandVos = brandVos.stream().map(item -> {
            BrandVo brand = new BrandVo();
            brand.setBrandId(item.getBrandId());
            brand.setBrandName(item.getName());
            return brand;
        }).collect(Collectors.toList());
        return Result.ok().put("data", collectBrandVos);
    }

    /**
     * @description 获取当前品牌的关联的的所有分类列表
     * @param: brandId
     * @date: 2022/7/28 12:16
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @GetMapping(value = "/catelog/list")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public Result cateloglist(@RequestParam("brandId") Long brandId) {
        List<CategoryBrandRelationEntity> data = categoryBrandRelationService.list(
                new QueryWrapper<CategoryBrandRelationEntity>().eq("brand_id", brandId));
        return Result.ok().put("data", data);
    }

    /**
     * @description 列表信息
     * @param: params
     * @date: 2022/7/28 12:16
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询信息
     * @param: id
     * @date: 2022/7/28 12:16
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:categorybrandrelation:info")
    public Result info(@PathVariable("id") Long id) {
        CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);
        return Result.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * @description 保存信息
     * @param: categoryBrandRelation
     * @date: 2022/7/28 12:17
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:categorybrandrelation:save")
    public Result save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation) {

        categoryBrandRelationService.saveDetial(categoryBrandRelation);
        return Result.ok();
    }

    /**
     * @description 更新信息
     * @param: categoryBrandRelation
     * @date: 2022/7/28 12:17
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:categorybrandrelation:update")
    public Result update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation) {
        categoryBrandRelationService.updateById(categoryBrandRelation);
        return Result.ok();
    }

    /**
     * @description 删除信息数据
     * @param: ids
     * @date: 2022/7/28 12:17
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:categorybrandrelation:delete")
    public Result delete(@RequestBody Long[] ids) {
        categoryBrandRelationService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
