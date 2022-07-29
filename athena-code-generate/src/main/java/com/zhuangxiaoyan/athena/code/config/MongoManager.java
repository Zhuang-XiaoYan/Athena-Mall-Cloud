package com.zhuangxiaoyan.athena.code.config;

import com.zhuangxiaoyan.athena.code.entity.MongoDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description MongoManager
 * @param: null
 * @date: 2022/7/29 12:28
 * @return:
 * @author: xjl
 */
public class MongoManager {

    /***
     * mongo扫描很消耗性能 尤其是子类的封装  使用缓存
     * @param: null
     * @date: 2022/7/29 12:28
     * @return:
     * @author: xjl
     */
    private static final Map<String, MongoDefinition> mongoCache = new ConcurrentHashMap<>();

    /**
     * @description getCache
     * @param:
     * @date: 2022/7/29 12:46
     * @return: java.util.Map<java.lang.String, com.zhuangxiaoyan.athena.code.entity.MongoDefinition>
     * @author: xjl
     */
    public static Map<String, MongoDefinition> getCache() {
        return mongoCache;
    }

    /**
     * @description getInfo
     * @param: tableName
     * @date: 2022/7/29 12:47
     * @return: com.zhuangxiaoyan.athena.code.entity.MongoDefinition
     * @author: xjl
     */
    public static MongoDefinition getInfo(String tableName) {
        return mongoCache.getOrDefault(tableName, null);
    }

    /**
     * @description putInfo
     * @param: tableName
     * @param: mongoDefinition
     * @date: 2022/7/29 12:47
     * @return: com.zhuangxiaoyan.athena.code.entity.MongoDefinition
     * @author: xjl
     */
    public static MongoDefinition putInfo(String tableName, MongoDefinition mongoDefinition) {
        return mongoCache.put(tableName, mongoDefinition);
    }

    /**
     * @description 当前配置是否为mongo内容
     * @param:
     * @date: 2022/7/29 12:47
     * @return: boolean
     * @author: xjl
     */
    public static boolean isMongo() {
        return DbConfig.isMongo();
    }

}
