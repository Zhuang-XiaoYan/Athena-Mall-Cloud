package com.zhuangxiaoyan.athena.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zhuangxiaoyan.athena.ware.dao")
@SpringBootApplication
public class AthenaWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaWareApplication.class, args);
    }

}
