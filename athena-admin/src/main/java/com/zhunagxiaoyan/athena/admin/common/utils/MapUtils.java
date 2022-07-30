package com.zhunagxiaoyan.athena.admin.common.utils;

import java.util.HashMap;

/**
 * @description Map工具类
 * @date: 2022/7/30 8:49
 * @author: xjl
*/
public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
