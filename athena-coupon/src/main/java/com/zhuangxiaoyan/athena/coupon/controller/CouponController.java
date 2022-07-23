package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.CouponEntity;
import com.zhuangxiaoyan.athena.coupon.service.CouponService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 优惠券信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    /**
     * 提供远程服务调用
     */
    @RequestMapping("/member/list")
    //@RequiresPermissions("coupon:coupon:list")
    public Result membercoupons() {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减10");
        return Result.ok().put("coupons", Arrays.asList(couponEntity));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:coupon:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = couponService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public Result info(@PathVariable("id") Long id) {
        CouponEntity coupon = couponService.getById(id);

        return Result.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public Result save(@RequestBody CouponEntity coupon) {
        couponService.save(coupon);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public Result update(@RequestBody CouponEntity coupon) {
        couponService.updateById(coupon);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public Result delete(@RequestBody Long[] ids) {
        couponService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
