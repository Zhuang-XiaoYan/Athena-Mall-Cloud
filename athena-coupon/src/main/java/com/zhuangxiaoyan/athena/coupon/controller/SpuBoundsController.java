package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.SpuBoundsEntity;
import com.zhuangxiaoyan.athena.coupon.service.SpuBoundsService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RestController
@RequestMapping("coupon/spubounds")
public class SpuBoundsController {
    @Autowired
    private SpuBoundsService spuBoundsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:spubounds:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = spuBoundsService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:spubounds:info")
    public Result info(@PathVariable("id") Long id) {
        SpuBoundsEntity spuBounds = spuBoundsService.getById(id);

        return Result.ok().put("spuBounds", spuBounds);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("coupon:spubounds:save")
    public Result save(@RequestBody SpuBoundsEntity spuBounds) {
        spuBoundsService.save(spuBounds);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:spubounds:update")
    public Result update(@RequestBody SpuBoundsEntity spuBounds) {
        spuBoundsService.updateById(spuBounds);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:spubounds:delete")
    public Result delete(@RequestBody Long[] ids) {
        spuBoundsService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
