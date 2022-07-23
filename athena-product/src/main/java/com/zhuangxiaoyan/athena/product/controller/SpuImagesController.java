package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.SpuImagesEntity;
import com.zhuangxiaoyan.athena.product.service.SpuImagesService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * spu图片
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
@RestController
@RequestMapping("product/spuimages")
public class SpuImagesController {
    @Autowired
    private SpuImagesService spuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuimages:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = spuImagesService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:spuimages:info")
    public Result info(@PathVariable("id") Long id) {
        SpuImagesEntity spuImages = spuImagesService.getById(id);

        return Result.ok().put("spuImages", spuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spuimages:save")
    public Result save(@RequestBody SpuImagesEntity spuImages) {
        spuImagesService.save(spuImages);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:spuimages:update")
    public Result update(@RequestBody SpuImagesEntity spuImages) {
        spuImagesService.updateById(spuImages);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spuimages:delete")
    public Result delete(@RequestBody Long[] ids) {
        spuImagesService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
