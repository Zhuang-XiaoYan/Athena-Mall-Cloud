package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.fegin.CouponFeginService;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname CouponFeginServiceFegin
 * @Description TODO
 * @Date 2022/3/13 14:08
 * @Created by xjl
 */
@RestController
@RequestMapping("product/product")
public class CouponFeginServiceFegin {

    @Autowired
    private CouponFeginService couponFeginService;

    /**
     * @description 调用远程服务
     * @param:
     * @date: 2022/3/13 14:09
     * @return: com.zhuangxiaoyan.common.utils.R
     * @author: xjl
     */
    @RequestMapping("/coupons")
    public Result test() {
        Result membercoupons = couponFeginService.membercoupons();
        return Result.ok().put("athena-product ", "athena-product fegin call athena coupons").put("coupon", membercoupons);
    }
}
