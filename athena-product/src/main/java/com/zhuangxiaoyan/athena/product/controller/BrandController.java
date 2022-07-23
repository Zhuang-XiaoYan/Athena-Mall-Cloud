package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.BrandEntity;
import com.zhuangxiaoyan.athena.product.service.BrandService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import com.zhuangxiaoyan.common.valid.SaveGroup;
import com.zhuangxiaoyan.common.valid.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 品牌
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = brandService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public Result info(@PathVariable("brandId") Long brandId) {
        BrandEntity brand = brandService.getById(brandId);
        return Result.ok().put("brand", brand);
    }

    /**
     * 保存 同时的对的相关的输入的数据的前端进行校验
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public Result save(@Validated(SaveGroup.class) @RequestBody BrandEntity brand) {
        brandService.save(brand);
        return Result.ok();
    }

    /**
     * 修改
     * @Validated(UpdateGroup.class)
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public Result update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand) {
        brandService.updateById(brand);
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public Result delete(@RequestBody Long[] brandIds) {
        brandService.removeByIds(Arrays.asList(brandIds));
        return Result.ok();
    }

}
