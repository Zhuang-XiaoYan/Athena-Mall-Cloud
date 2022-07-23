package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.CouponHistoryEntity;
import com.zhuangxiaoyan.athena.coupon.service.CouponHistoryService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RestController
@RequestMapping("coupon/couponhistory")
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService couponHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:couponhistory:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = couponHistoryService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:couponhistory:info")
    public Result info(@PathVariable("id") Long id) {
        CouponHistoryEntity couponHistory = couponHistoryService.getById(id);

        return Result.ok().put("couponHistory", couponHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:couponhistory:save")
    public Result save(@RequestBody CouponHistoryEntity couponHistory) {
        couponHistoryService.save(couponHistory);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:couponhistory:update")
    public Result update(@RequestBody CouponHistoryEntity couponHistory) {
        couponHistoryService.updateById(couponHistory);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:couponhistory:delete")
    public Result delete(@RequestBody Long[] ids) {
        couponHistoryService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
