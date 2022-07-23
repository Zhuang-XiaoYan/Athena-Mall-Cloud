package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.HomeAdvEntity;
import com.zhuangxiaoyan.athena.coupon.service.HomeAdvService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RestController
@RequestMapping("coupon/homeadv")
public class HomeAdvController {
    @Autowired
    private HomeAdvService homeAdvService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:homeadv:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = homeAdvService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:homeadv:info")
    public Result info(@PathVariable("id") Long id) {
        HomeAdvEntity homeAdv = homeAdvService.getById(id);

        return Result.ok().put("homeAdv", homeAdv);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:homeadv:save")
    public Result save(@RequestBody HomeAdvEntity homeAdv) {
        homeAdvService.save(homeAdv);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:homeadv:update")
    public Result update(@RequestBody HomeAdvEntity homeAdv) {
        homeAdvService.updateById(homeAdv);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:homeadv:delete")
    public Result delete(@RequestBody Long[] ids) {
        homeAdvService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
