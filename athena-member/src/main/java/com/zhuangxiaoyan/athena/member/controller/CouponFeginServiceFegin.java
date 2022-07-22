package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.entity.MemberEntity;
import com.zhuangxiaoyan.athena.member.fegin.CouponFeginService;
import com.zhuangxiaoyan.common.utils.R;
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
@RequestMapping("member/member")
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
    public R test() {
        MemberEntity member = new MemberEntity();
        member.setNickname("庄小焱");
        R result = couponFeginService.membercoupons();
        return R.ok().put("member", member).put("coupons", result.get("coupons"));
    }
}
