package com.zhuangxiaoyan.athena.code.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author: gxz gongxuanzhang@foxmail.com
 **/
public class MongoNullCondition implements Condition {

    /**
     * @description matches
     * @param: context
     * @param: metadata
     * @date: 2022/7/29 12:49
     * @return: boolean
     * @author: xjl
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String database = context.getEnvironment().getProperty("athena.database");
        return !"mongodb".equalsIgnoreCase(database);
    }
}
