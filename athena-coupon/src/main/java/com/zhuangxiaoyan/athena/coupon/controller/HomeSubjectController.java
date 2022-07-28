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
 * @description 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * @date: 2022/7/28 15:34
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/homesubject")
public class HomeSubjectController {

    @Autowired
    private HomeSubjectService homeSubjectService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/28 15:35
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:homesubject:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = homeSubjectService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过Id进行查询
     * @param: id
     * @date: 2022/7/28 15:35
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:homesubject:info")
    public Result info(@PathVariable("id") Long id) {
        HomeSubjectEntity homeSubject = homeSubjectService.getById(id);
        return Result.ok().put("homeSubject", homeSubject);
    }

    /**
     * @description 保存数据
     * @param: homeSubject
     * @date: 2022/7/28 15:35
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:homesubject:save")
    public Result save(@RequestBody HomeSubjectEntity homeSubject) {
        homeSubjectService.save(homeSubject);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: homeSubject
     * @date: 2022/7/28 15:35
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:homesubject:update")
    public Result update(@RequestBody HomeSubjectEntity homeSubject) {
        homeSubjectService.updateById(homeSubject);
        return Result.ok();
    }

    /**
     * @description 删除
     * @param: ids
     * @date: 2022/7/28 15:36
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:homesubject:delete")
    public Result delete(@RequestBody Long[] ids) {
        homeSubjectService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
