package com.zhuangxiaoyan.athena.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@MapperScan("com.zhuangxiaoyan.athena.code.dao")
public class AthenaCodeGenerateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaCodeGenerateApplication.class, args);
    }

}