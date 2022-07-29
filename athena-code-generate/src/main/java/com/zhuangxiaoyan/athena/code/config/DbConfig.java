package com.zhuangxiaoyan.athena.code.config;

import com.zhuangxiaoyan.athena.code.dao.*;
import com.zhuangxiaoyan.athena.code.service.utils.AthenaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @description 数据库配置
 * @date: 2022/7/29 12:47
 * @author: xjl
 */
@Configuration
public class DbConfig {

    private static boolean mongo = false;

    @Value("${athena.database: mysql}")
    private String database;

    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;

    @Autowired
    private OracleGeneratorDao oracleGeneratorDao;

    @Autowired
    private SQLServerGeneratorDao sqlServerGeneratorDao;

    @Autowired
    private PostgreSQLGeneratorDao postgreSQLGeneratorDao;

    public static boolean isMongo() {
        return mongo;
    }

    @Bean
    @Primary
    @Conditional(MongoNullCondition.class)
    public GeneratorDao getGeneratorDao() {
        if ("mysql".equalsIgnoreCase(database)) {
            return mySQLGeneratorDao;
        } else if ("oracle".equalsIgnoreCase(database)) {
            return oracleGeneratorDao;
        } else if ("sqlserver".equalsIgnoreCase(database)) {
            return sqlServerGeneratorDao;
        } else if ("postgresql".equalsIgnoreCase(database)) {
            return postgreSQLGeneratorDao;
        } else {
            throw new AthenaException("不支持当前数据库：" + database);
        }
    }

    @Bean
    @Primary
    @Conditional(MongoCondition.class)
    public GeneratorDao getMongoDBDao(MongoDBGeneratorDao mongoDBGeneratorDao) {
        mongo = true;
        return mongoDBGeneratorDao;
    }
}
