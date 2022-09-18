package com.zhuangxiaoyan.athena.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableRedisHttpSession// 开启共享的session
@EnableFeignClients(basePackages = "com.zhuangxiaoyan.athena.order.fegin")// 开启远程调用功能
@MapperScan("com.zhuangxiaoyan.athena.order.dao")// 开启mybastis的加载
// @EnableAspectJAutoProxy(exposeProxy = true)// 使用aspect的动态代理的功能
@EnableTransactionManagement // 开启本地事务
@EnableDiscoveryClient // 开启的注册与发现功能
@EnableRabbit // 开启mq
@SpringBootApplication
public class AthenaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaOrderApplication.class, args);
    }

}
