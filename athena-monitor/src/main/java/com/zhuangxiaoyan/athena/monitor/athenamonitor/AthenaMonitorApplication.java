package com.zhuangxiaoyan.athena.monitor.athenamonitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class AthenaMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaMonitorApplication.class, args);
    }

}
