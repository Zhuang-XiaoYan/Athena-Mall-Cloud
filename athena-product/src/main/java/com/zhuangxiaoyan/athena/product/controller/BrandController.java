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
 * @description 品牌信息
 * @date: 2022/7/28 12:13
 * @return:
 * @author: xjl
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * @description 查询所有的信息
     * @param: params
     * @date: 2022/7/28 12:13
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = brandService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过的brandId查询的信息
     * @param: brandId
     * @date: 2022/7/28 12:13
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public Result info(@PathVariable("brandId") Long brandId) {
        BrandEntity brand = brandService.getById(brandId);
        return Result.ok().put("brand", brand);
    }

    /**
     * @description 保存 同时的对的相关的输入的数据的前端进行校验
     * @param: null
     * @date: 2022/7/28 12:14
     * @return:
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public Result save(@Validated(SaveGroup.class) @RequestBody BrandEntity brand) {
        brandService.save(brand);
        return Result.ok();
    }

    /**
     * @description 涉及到多表关联的时候不能只能使用简单的单表的保存，需要的考虑到多表的冗余与数据的同步，
     * 因此需要在每每次的基础的操作中的做好相关的检查。
     * @Validated(UpdateGroup.class)
     * @param: null
     * @date: 2022/7/28 12:14
     * @return:
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public Result update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand) {

        brandService.updateDetail(brand);
        return Result.ok();
    }

    /**
     * @description 删除相关数据
     * @param: brandIds
     * @date: 2022/7/28 12:14
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public Result delete(@RequestBody Long[] brandIds) {
        brandService.removeByIds(Arrays.asList(brandIds));
        return Result.ok();
    }

}
