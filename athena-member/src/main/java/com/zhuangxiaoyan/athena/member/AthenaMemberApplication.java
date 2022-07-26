package com.zhuangxiaoyan.athena.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients(basePackages = "com.zhuangxiaoyan.athena.member.fegin")
@MapperScan("com.zhuangxiaoyan.athena.member.dao")
@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
public class AthenaMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaMemberApplication.class, args);
    }

}
