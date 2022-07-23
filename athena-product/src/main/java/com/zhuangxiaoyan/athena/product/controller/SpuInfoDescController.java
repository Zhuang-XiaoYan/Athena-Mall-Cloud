package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.SpuInfoDescEntity;
import com.zhuangxiaoyan.athena.product.service.SpuInfoDescService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * spu信息介绍
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {
    @Autowired
    private SpuInfoDescService spuInfoDescService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuinfodesc:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = spuInfoDescService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{spuId}")
    //@RequiresPermissions("product:spuinfodesc:info")
    public Result info(@PathVariable("spuId") Long spuId) {
        SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);

        return Result.ok().put("spuInfoDesc", spuInfoDesc);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spuinfodesc:save")
    public Result save(@RequestBody SpuInfoDescEntity spuInfoDesc) {
        spuInfoDescService.save(spuInfoDesc);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:spuinfodesc:update")
    public Result update(@RequestBody SpuInfoDescEntity spuInfoDesc) {
        spuInfoDescService.updateById(spuInfoDesc);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spuinfodesc:delete")
    public Result delete(@RequestBody Long[] spuIds) {
        spuInfoDescService.removeByIds(Arrays.asList(spuIds));

        return Result.ok();
    }

}
