package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.HomeSubjectEntity;
import com.zhuangxiaoyan.athena.coupon.service.HomeSubjectService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RestController
@RequestMapping("coupon/homesubject")
public class HomeSubjectController {
    @Autowired
    private HomeSubjectService homeSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:homesubject:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = homeSubjectService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:homesubject:info")
    public Result info(@PathVariable("id") Long id) {
        HomeSubjectEntity homeSubject = homeSubjectService.getById(id);

        return Result.ok().put("homeSubject", homeSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:homesubject:save")
    public Result save(@RequestBody HomeSubjectEntity homeSubject) {
        homeSubjectService.save(homeSubject);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:homesubject:update")
    public Result update(@RequestBody HomeSubjectEntity homeSubject) {
        homeSubjectService.updateById(homeSubject);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:homesubject:delete")
    public Result delete(@RequestBody Long[] ids) {
        homeSubjectService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
