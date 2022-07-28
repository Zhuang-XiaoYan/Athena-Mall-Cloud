package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.CouponSpuRelationEntity;
import com.zhuangxiaoyan.athena.coupon.service.CouponSpuRelationService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 优惠券与产品关联
 * @date: 2022/7/28 15:31
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/couponspurelation")
public class CouponSpuRelationController {

    @Autowired
    private CouponSpuRelationService couponSpuRelationService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/28 15:31
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:couponspurelation:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = couponSpuRelationService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id进行的查询
     * @param: id
     * @date: 2022/7/28 15:32
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:couponspurelation:info")
    public Result info(@PathVariable("id") Long id) {
        CouponSpuRelationEntity couponSpuRelation = couponSpuRelationService.getById(id);
        return Result.ok().put("couponSpuRelation", couponSpuRelation);
    }

    /**
     * @description 保存数据
     * @param: couponSpuRelation
     * @date: 2022/7/28 15:32
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:couponspurelation:save")
    public Result save(@RequestBody CouponSpuRelationEntity couponSpuRelation) {
        couponSpuRelationService.save(couponSpuRelation);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: couponSpuRelation
     * @date: 2022/7/28 15:32
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:couponspurelation:update")
    public Result update(@RequestBody CouponSpuRelationEntity couponSpuRelation) {
        couponSpuRelationService.updateById(couponSpuRelation);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 15:32
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:couponspurelation:delete")
    public Result delete(@RequestBody Long[] ids) {
        couponSpuRelationService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
