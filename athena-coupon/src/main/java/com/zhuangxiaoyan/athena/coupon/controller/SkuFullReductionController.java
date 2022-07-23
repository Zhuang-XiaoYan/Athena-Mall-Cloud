package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.SkuFullReductionEntity;
import com.zhuangxiaoyan.athena.coupon.service.SkuFullReductionService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 商品满减信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RestController
@RequestMapping("coupon/skufullreduction")
public class SkuFullReductionController {
    @Autowired
    private SkuFullReductionService skuFullReductionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:skufullreduction:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = skuFullReductionService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:skufullreduction:info")
    public Result info(@PathVariable("id") Long id) {
        SkuFullReductionEntity skuFullReduction = skuFullReductionService.getById(id);

        return Result.ok().put("skuFullReduction", skuFullReduction);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:skufullreduction:save")
    public Result save(@RequestBody SkuFullReductionEntity skuFullReduction) {
        skuFullReductionService.save(skuFullReduction);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:skufullreduction:update")
    public Result update(@RequestBody SkuFullReductionEntity skuFullReduction) {
        skuFullReductionService.updateById(skuFullReduction);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:skufullreduction:delete")
    public Result delete(@RequestBody Long[] ids) {
        skuFullReductionService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
