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
 * @description 优惠券信息
 * @date: 2022/7/28 15:20
 * @author: xjl
 */
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    /**
     * @description producers提供远程服务调用测试
     * @param:
     * @date: 2022/7/28 15:22
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/member/list")
    //@RequiresPermissions("coupon:coupon:list")
    public Result membercoupons() {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减10");
        return Result.ok().put("coupons", Arrays.asList(couponEntity));
    }

    /**
     * @description 查询列表信息
     * @param: params
     * @date: 2022/7/28 15:22
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:coupon:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = couponService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询
     * @param: id
     * @date: 2022/7/28 15:26
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public Result info(@PathVariable("id") Long id) {
        CouponEntity coupon = couponService.getById(id);
        return Result.ok().put("coupon", coupon);
    }

    /**
     * @description 保存信息
     * @param: coupon
     * @date: 2022/7/28 15:27
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public Result save(@RequestBody CouponEntity coupon) {
        couponService.save(coupon);
        return Result.ok();
    }

    /**
     * @description 更新信息
     * @param: coupon
     * @date: 2022/7/28 15:27
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public Result update(@RequestBody CouponEntity coupon) {
        couponService.updateById(coupon);
        return Result.ok();
    }

    /**
     * @description 删除信息
     * @param: ids
     * @date: 2022/7/28 15:27
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public Result delete(@RequestBody Long[] ids) {
        couponService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
