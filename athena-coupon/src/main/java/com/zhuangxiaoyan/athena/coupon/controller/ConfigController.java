package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.common.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置中心测试文件
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class ConfigController {

    @Value("${coupon.user.name}")
    private String name;
    @Value("${coupon.user.age}")
    private Integer age;

    /**
     * 提供远程服务调用
     */
    @RequestMapping("/valuetest")
    public R membercoupons() {
        return R.ok().put("name", name).put("age", age);
    }

}
