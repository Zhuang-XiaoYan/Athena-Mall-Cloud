package com.zhuangxiaoyan.athena.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description AthenaElasticSearchConfig 配置类
 * @Date 2022/7/31 17:11
 * @Created by xjl
 */
@Configuration
public class AthenaElasticSearchConfig {

    public static final RequestOptions COMMON_OPTIONS;

    public static String HostIp = "192.168.25.137";
    public static Integer Port = 9200;
    public static String Type = "http";

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        COMMON_OPTIONS = builder.build();
    }

    /**
     * @description 构建一个的es的客户端
     * @param:
     * @date: 2022/7/31 17:17
     * @return: org.elasticsearch.client.RestHighLevelClient
     * @author: xjl
     */
    @Bean
    public RestHighLevelClient esRestClient() {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(HostIp, Port, Type)));
        return client;
    }
}
