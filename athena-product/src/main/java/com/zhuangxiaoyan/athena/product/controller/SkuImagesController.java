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
 * @description sku图片
 * @date: 2022/7/28 12:24
 * @return:
 * @author: xjl
 */
@RestController
@RequestMapping("product/skuimages")
public class SkuImagesController {

    @Autowired
    private SkuImagesService skuImagesService;

    /**
     * @description 查询所有的sku的图片信息
     * @param: params
     * @date: 2022/7/28 12:24
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:skuimages:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = skuImagesService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询信息
     * @param: id
     * @date: 2022/7/28 12:24
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:skuimages:info")
    public Result info(@PathVariable("id") Long id) {
        SkuImagesEntity skuImages = skuImagesService.getById(id);
        return Result.ok().put("skuImages", skuImages);
    }

    /**
     * @description 保存信息
     * @param: skuImages
     * @date: 2022/7/28 12:25
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:skuimages:save")
    public Result save(@RequestBody SkuImagesEntity skuImages) {
        skuImagesService.save(skuImages);
        return Result.ok();
    }

    /**
     * @description 更新信息
     * @param: skuImages
     * @date: 2022/7/28 12:25
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:skuimages:update")
    public Result update(@RequestBody SkuImagesEntity skuImages) {
        skuImagesService.updateById(skuImages);
        return Result.ok();
    }

    /**
     * @description 删除信息
     * @param: ids
     * @date: 2022/7/28 12:25
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:skuimages:delete")
    public Result delete(@RequestBody Long[] ids) {
        skuImagesService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
