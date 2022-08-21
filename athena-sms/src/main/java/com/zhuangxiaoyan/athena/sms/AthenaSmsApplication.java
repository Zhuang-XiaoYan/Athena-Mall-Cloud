package com.zhuangxiaoyan.athena.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients(basePackages = "com.zhuangxiaoyan.athena.sms.fegin")
@EnableTransactionManagement// 开启了事务注解
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AthenaSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaSmsApplication.class, args);
    }

}
