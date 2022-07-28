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
 * @description 优惠券领取历史记录
 * @date: 2022/7/28 15:28
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/couponhistory")
public class CouponHistoryController {

    @Autowired
    private CouponHistoryService couponHistoryService;

    /**
     * @description 查询所有信息
     * @param: params
     * @date: 2022/7/28 15:28
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:couponhistory:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = couponHistoryService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询
     * @param: id
     * @date: 2022/7/28 15:28
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:couponhistory:info")
    public Result info(@PathVariable("id") Long id) {
        CouponHistoryEntity couponHistory = couponHistoryService.getById(id);
        return Result.ok().put("couponHistory", couponHistory);
    }

    /**
     * @description 保存数据
     * @param: couponHistory
     * @date: 2022/7/28 15:29
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:couponhistory:save")
    public Result save(@RequestBody CouponHistoryEntity couponHistory) {
        couponHistoryService.save(couponHistory);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: couponHistory
     * @date: 2022/7/28 15:29
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:couponhistory:update")
    public Result update(@RequestBody CouponHistoryEntity couponHistory) {
        couponHistoryService.updateById(couponHistory);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 15:29
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:couponhistory:delete")
    public Result delete(@RequestBody Long[] ids) {
        couponHistoryService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
