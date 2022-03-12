package com.zhuangxiaoyan.athena.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@MapperScan("com.zhuangxiaoyan.athena.product.dao")
@SpringBootApplication
public class AthenaProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaProductApplication.class, args);
    }
}
