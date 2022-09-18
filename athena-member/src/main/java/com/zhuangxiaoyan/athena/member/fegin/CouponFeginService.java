package com.zhuangxiaoyan.athena.member.fegin;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 声明式的远程调用
 * @Date 2022/3/12 15:16
 *@author: xjl
 */

@FeignClient("athena-coupon")
public interface CouponFeginService {

    /**
     * @description 远程调用的方式
     * @param:
     * @date: 2022/3/12 15:18
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/coupon/coupon/member/list")
    public Result membercoupons();
}
