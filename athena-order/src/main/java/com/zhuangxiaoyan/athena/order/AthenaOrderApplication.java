package com.zhuangxiaoyan.athena.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zhuangxiaoyan.athena.order.dao")
@SpringBootApplication
public class AthenaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaOrderApplication.class, args);
    }

}
