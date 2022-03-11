package com.zhuangxiaoyan.athena.product.feign;

import com.zhuangxiaoyan.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("athena-coupon")
public interface CouponFeignService {

    /**
     * 提供远程服务调用
     */
    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
