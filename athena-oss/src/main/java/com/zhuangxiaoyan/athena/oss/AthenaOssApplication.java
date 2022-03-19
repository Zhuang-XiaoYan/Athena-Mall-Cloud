package com.zhuangxiaoyan.athena.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
public class AthenaOssApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthenaOssApplication.class, args);
	}

}
