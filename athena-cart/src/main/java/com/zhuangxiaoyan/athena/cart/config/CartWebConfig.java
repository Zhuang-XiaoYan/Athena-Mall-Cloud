package com.zhuangxiaoyan.athena.cart.config;

import com.zhuangxiaoyan.athena.cart.interceptor.CartInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description 配置拦截器的作用
  * @param: null
 * @date: 2022/9/3 9:24
 * @return:
 * @author: xjl
*/

@Configuration
public class CartWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CartInterceptor())//注册拦截器
                .addPathPatterns("/**");
    }
}
