package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.SkuLadderEntity;
import com.zhuangxiaoyan.athena.coupon.service.SkuLadderService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 商品阶梯价格
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RestController
@RequestMapping("coupon/skuladder")
public class SkuLadderController {
    @Autowired
    private SkuLadderService skuLadderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:skuladder:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = skuLadderService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:skuladder:info")
    public Result info(@PathVariable("id") Long id) {
        SkuLadderEntity skuLadder = skuLadderService.getById(id);

        return Result.ok().put("skuLadder", skuLadder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:skuladder:save")
    public Result save(@RequestBody SkuLadderEntity skuLadder) {
        skuLadderService.save(skuLadder);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:skuladder:update")
    public Result update(@RequestBody SkuLadderEntity skuLadder) {
        skuLadderService.updateById(skuLadder);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:skuladder:delete")
    public Result delete(@RequestBody Long[] ids) {
        skuLadderService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
