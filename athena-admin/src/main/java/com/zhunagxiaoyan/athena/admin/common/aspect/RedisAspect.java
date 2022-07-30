package com.zhunagxiaoyan.athena.admin.common.aspect;

import com.zhunagxiaoyan.athena.admin.common.exception.AthenaException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @description Redis切面处理类
 * @date: 2022/3/16 7:45
 * @author: xjl
 */
@Aspect
@Configuration
public class RedisAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    //是否开启redis缓存  true开启   false关闭
    @Value("${spring.redis.open: false}")
    private boolean open;

    @Around("execution(* com.zhunagxiaoyan.athena.admin.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if (open) {
            try {
                result = point.proceed();
            } catch (Exception e) {
                logger.error("redis error", e);
                throw new AthenaException("Redis服务异常");
            }
        }
        return result;
    }
}
