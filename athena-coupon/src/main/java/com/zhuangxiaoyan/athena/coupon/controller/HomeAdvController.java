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
 * @description 首页轮播广告
 * @param: null
 * @date: 2022/7/28 15:33
 * @return:
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/homeadv")
public class HomeAdvController {

    @Autowired
    private HomeAdvService homeAdvService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/28 15:33
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:homeadv:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = homeAdvService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id简单的的查询
     * @param: id
     * @date: 2022/7/28 15:33
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:homeadv:info")
    public Result info(@PathVariable("id") Long id) {
        HomeAdvEntity homeAdv = homeAdvService.getById(id);
        return Result.ok().put("homeAdv", homeAdv);
    }

    /**
     * @description 保存数据
     * @param: homeAdv
     * @date: 2022/7/28 15:34
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:homeadv:save")
    public Result save(@RequestBody HomeAdvEntity homeAdv) {
        homeAdvService.save(homeAdv);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: homeAdv
     * @date: 2022/7/28 15:34
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:homeadv:update")
    public Result update(@RequestBody HomeAdvEntity homeAdv) {
        homeAdvService.updateById(homeAdv);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 15:34
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:homeadv:delete")
    public Result delete(@RequestBody Long[] ids) {
        homeAdvService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
