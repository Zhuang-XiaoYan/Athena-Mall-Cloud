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
 * @description 专题商品
 * @date: 2022/7/28 15:36
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/homesubjectspu")
public class HomeSubjectSpuController {

    @Autowired
    private HomeSubjectSpuService homeSubjectSpuService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/28 15:36
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:homesubjectspu:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = homeSubjectSpuService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/28 15:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:homesubjectspu:info")
    public Result info(@PathVariable("id") Long id) {
        HomeSubjectSpuEntity homeSubjectSpu = homeSubjectSpuService.getById(id);
        return Result.ok().put("homeSubjectSpu", homeSubjectSpu);
    }

    /**
     * @description 保存数据
     * @param: homeSubjectSpu
     * @date: 2022/7/28 15:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:homesubjectspu:save")
    public Result save(@RequestBody HomeSubjectSpuEntity homeSubjectSpu) {
        homeSubjectSpuService.save(homeSubjectSpu);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: homeSubjectSpu
     * @date: 2022/7/28 15:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:homesubjectspu:update")
    public Result update(@RequestBody HomeSubjectSpuEntity homeSubjectSpu) {
        homeSubjectSpuService.updateById(homeSubjectSpu);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 15:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:homesubjectspu:delete")
    public Result delete(@RequestBody Long[] ids) {
        homeSubjectSpuService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
