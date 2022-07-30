package com.zhunagxiaoyan.athena.admin.common.utils;

/**
 * @description Redis所有Keys
 * @date: 2022/7/30 8:50
 * @author: xjl
*/
public class RedisKeys {

    public static String getSysConfigKey(String key) {
        return "sys:config:" + key;
    }
}
