package com.zhuangxiaoyan.athena.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
public class AthenaProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaProductApplication.class, args);
    }
}
