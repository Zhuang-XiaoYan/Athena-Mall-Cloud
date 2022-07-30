package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.fegin.CouponFeginService;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description CouponFeginServiceFegin
 * @date: 2022/7/30 22:41
 * @author: xjl
*/

@RestController
@RequestMapping("order/order")
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
        return Result.ok().put("athena-order ", "athena-order fegin call athena coupons").put("coupon", membercoupons);
    }
}
