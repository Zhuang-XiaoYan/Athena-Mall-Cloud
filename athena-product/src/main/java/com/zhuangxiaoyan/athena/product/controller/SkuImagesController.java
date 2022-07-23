package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.SkuImagesEntity;
import com.zhuangxiaoyan.athena.product.service.SkuImagesService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * sku图片
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
@RestController
@RequestMapping("product/skuimages")
public class SkuImagesController {
    @Autowired
    private SkuImagesService skuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:skuimages:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = skuImagesService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:skuimages:info")
    public Result info(@PathVariable("id") Long id) {
        SkuImagesEntity skuImages = skuImagesService.getById(id);

        return Result.ok().put("skuImages", skuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:skuimages:save")
    public Result save(@RequestBody SkuImagesEntity skuImages) {
        skuImagesService.save(skuImages);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:skuimages:update")
    public Result update(@RequestBody SkuImagesEntity skuImages) {
        skuImagesService.updateById(skuImages);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:skuimages:delete")
    public Result delete(@RequestBody Long[] ids) {
        skuImagesService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
