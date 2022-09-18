package com.zhuangxiaoyan.athena.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @Classname RedissonConfig
 * @Date 2022/8/13 17:11
 *@author: xjl
 */

@Configuration
public class RedissonConfig {

    /**
     * @description 所有对Redisson的使用都是通过RedissonClient
     * 这里使用的单节点的redisson
     * @param:
     * @date: 2022/8/13 17:12
     * @return: org.redisson.api.RedissonClient
     * @author: xjl
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonSingle() throws IOException {
        //1、创建配置
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://192.168.25.137:6379");
        //2、根据Config创建出RedissonClient实例
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }

    /**
     * @description Redisson的集群模式配置
     * @param:
     * @date: 2022/8/13 17:20
     * @return: org.redisson.api.RedissonClient
     * @author: xjl
     */
//    @Bean(destroyMethod = "shutdown")
//    public RedissonClient redissonCluster() throws IOException {
//        //1、创建配置
//        Config config = new Config();
//        config.useClusterServers().setScanInterval(10)
//                .addNodeAddress("redis://192.168.25.137:6379")
//                .addNodeAddress("redis://192.168.25.137:6380")
//                .addNodeAddress("redis://192.168.25.137:6381");
//        //2、根据Config创建出RedissonClient实例
//        RedissonClient redissonClient = Redisson.create(config);
//        return redissonClient;
//    }
}
