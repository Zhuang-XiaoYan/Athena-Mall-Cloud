package com.zhuangxiaoyan.athena.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableRedisHttpSession // 开启redis整合的session的相关的整合
@EnableFeignClients(basePackages = "com.zhuangxiaoyan.athena.sso.fegin")
@EnableTransactionManagement// 开启了事务注解
@EnableDiscoveryClient
@SpringBootApplication
public class AthenaSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaSsoApplication.class, args);
    }

}
