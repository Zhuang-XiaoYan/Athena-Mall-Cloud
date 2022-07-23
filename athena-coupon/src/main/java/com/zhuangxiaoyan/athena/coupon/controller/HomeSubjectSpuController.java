package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.HomeSubjectSpuEntity;
import com.zhuangxiaoyan.athena.coupon.service.HomeSubjectSpuService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 专题商品
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RestController
@RequestMapping("coupon/homesubjectspu")
public class HomeSubjectSpuController {
    @Autowired
    private HomeSubjectSpuService homeSubjectSpuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:homesubjectspu:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = homeSubjectSpuService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:homesubjectspu:info")
    public Result info(@PathVariable("id") Long id) {
        HomeSubjectSpuEntity homeSubjectSpu = homeSubjectSpuService.getById(id);

        return Result.ok().put("homeSubjectSpu", homeSubjectSpu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:homesubjectspu:save")
    public Result save(@RequestBody HomeSubjectSpuEntity homeSubjectSpu) {
        homeSubjectSpuService.save(homeSubjectSpu);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:homesubjectspu:update")
    public Result update(@RequestBody HomeSubjectSpuEntity homeSubjectSpu) {
        homeSubjectSpuService.updateById(homeSubjectSpu);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:homesubjectspu:delete")
    public Result delete(@RequestBody Long[] ids) {
        homeSubjectSpuService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
