package com.zhuangxiaoyan.athena.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients(basePackages = "com.zhuangxiaoyan.athena.product.fegin")
@MapperScan("com.zhuangxiaoyan.athena.product.dao")
@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
public class AthenaProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaProductApplication.class, args);
    }
}
