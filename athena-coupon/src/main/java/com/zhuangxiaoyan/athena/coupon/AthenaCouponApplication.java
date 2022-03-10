package com.zhuangxiaoyan.athena.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zhuangxiaoyan.athena.coupon.dao")
@SpringBootApplication
public class AthenaCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaCouponApplication.class, args);
    }

}
