package com.zhuangxiaoyan.athena.cart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description ThreadPoolConfigProperties
 * @param: null
 * @date: 2022/8/21 9:32
 * @return:
 * @author: xjl
 */

@ConfigurationProperties(prefix = "athena.cart.thread")
@Data
public class ThreadPoolConfigProperties {

    private Integer coreSize;

    private Integer maxSize;

    private Integer keepAliveTime;

}
