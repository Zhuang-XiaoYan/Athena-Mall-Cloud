package com.zhuangxiaoyan.athena.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching// 开启spring cache的功能
@EnableFeignClients(basePackages = "com.zhuangxiaoyan.athena.product.fegin")
@MapperScan("com.zhuangxiaoyan.athena.product.dao")
@EnableTransactionManagement// 开启了事务注解
@EnableDiscoveryClient
@SpringBootApplication
public class AthenaProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaProductApplication.class, args);
    }
}
