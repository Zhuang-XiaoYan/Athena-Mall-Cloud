package com.zhuangxiaoyan.athena.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AthenaCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaCouponApplication.class, args);
    }

}
