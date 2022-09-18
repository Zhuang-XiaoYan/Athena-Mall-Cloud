package com.zhuangxiaoyan.athena.product.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description MybatisConfig
 * @Date 2022/7/23 10:02
 *@author: xjl
 */
@Configuration
public class MybatisConfig {

    /**
     * @description 引入分页插件
     * @param: null
     * @date: 2022/7/23 10:05
     * @return:
     * @author: xjl
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInterceptor.setOverflow(true);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInterceptor.setLimit(500);
        return paginationInterceptor;
    }
}
