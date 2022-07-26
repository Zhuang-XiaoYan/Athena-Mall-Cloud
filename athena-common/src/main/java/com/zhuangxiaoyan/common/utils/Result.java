/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.zhuangxiaoyan.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 返回数据
 * @param: null
 * @date: 2022/3/19 18:37
 * @return:
 * @author: xjl
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public Result setData(Object data) {
        put("data", data);
        return this;
    }

    //利用fastjson进行反序列化
    public <T> T getData(TypeReference<T> typeReference) {
        Object data = get("data");    //默认是map
        String jsonString = JSON.toJSONString(data);
        T t = JSON.parseObject(jsonString, typeReference);
        return t;
    }

    //利用fastjson进行反序列化
    public <T> T getData(String key, TypeReference<T> typeReference) {
        Object data = get(key);    //默认是map
        String jsonString = JSON.toJSONString(data);
        T t = JSON.parseObject(jsonString, typeReference);
        return t;
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Integer getCode() {
        return (Integer) this.get("code");
    }
}
