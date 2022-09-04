package com.zhuangxiaoyan.athena.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableRedisHttpSession //  开启spring session的功能
@EnableFeignClients(basePackages = "com.zhuangxiaoyan.athena.cart.fegin")
@EnableTransactionManagement// 开启了事务注解
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AthenaCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaCartApplication.class, args);
    }

}
