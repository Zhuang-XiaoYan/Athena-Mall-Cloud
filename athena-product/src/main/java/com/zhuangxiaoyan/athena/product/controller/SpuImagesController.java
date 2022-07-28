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
 * @description spu的图片类
 * @date: 2022/7/28 12:38
 * @return:
 * @author: xjl
 */
@RestController
@RequestMapping("product/spuimages")
public class SpuImagesController {

    @Autowired
    private SpuImagesService spuImagesService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/28 12:38
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuimages:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = spuImagesService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/28 12:38
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:spuimages:info")
    public Result info(@PathVariable("id") Long id) {
        SpuImagesEntity spuImages = spuImagesService.getById(id);
        return Result.ok().put("spuImages", spuImages);
    }

    /**
     * @description 保存数据
     * @param: spuImages
     * @date: 2022/7/28 12:45
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spuimages:save")
    public Result save(@RequestBody SpuImagesEntity spuImages) {
        spuImagesService.save(spuImages);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: spuImages
     * @date: 2022/7/28 12:45
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:spuimages:update")
    public Result update(@RequestBody SpuImagesEntity spuImages) {
        spuImagesService.updateById(spuImages);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 12:45
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spuimages:delete")
    public Result delete(@RequestBody Long[] ids) {
        spuImagesService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
