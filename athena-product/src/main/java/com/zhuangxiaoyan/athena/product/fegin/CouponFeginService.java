package com.zhuangxiaoyan.athena.product.fegin;

import com.zhuangxiaoyan.common.to.SkuReductionTo;
import com.zhuangxiaoyan.common.to.SpuBoundTo;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname CouponFeginService
 * @Description
 * 声明式的远程调用功能
 * 将参数的转为json
 * 远程调用微服务给/coupon/spubounds/save/ 发送请求 将上一步的json放在请求体中，发送请求。
 * 对方服务收到请求请求体中的sjon数据
 * 将数据的转为对应的数据的封装
 * @Date 2022/3/12 15:16
 * @Created by xjl
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
    /**
     * @description
     * 只要json数据模型是的兼容的，
      * @param: spuBoundTo
     * @date: 2022/7/26 7:47
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @PostMapping("/coupon/spubounds/save")
    public Result saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    Result saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
