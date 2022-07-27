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
 * @description 系统统一返回数据
 * @date: 2022/3/19 18:37
 * @author: xjl
 */
public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * @description Result构造类
     * @param: null
     * @date: 2022/7/27 21:33
     * @return:
     * @author: xjl
     */
    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    /**
     * @description error()
     * @param: null
     * @date: 2022/7/27 21:36
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "系统内部服务异常");
    }

    /**
     * @description error(String msg)
     * @param: msg
     * @date: 2022/7/27 21:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    /**
     * @description error(int code, String msg)
     * @param: code
     * @param: msg
     * @date: 2022/7/27 21:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    /**
     * @description ok(String msg)
     * @param: msg
     * @date: 2022/7/27 21:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    public static Result ok(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    /**
     * @description ok(Map < String, Object > map)
     * @param: msg
     * @date: 2022/7/27 21:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    public static Result ok(Map<String, Object> map) {
        Result result = new Result();
        result.putAll(map);
        return result;
    }

    /**
     * @description ok()
     * @param: msg
     * @date: 2022/7/27 21:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    public static Result ok() {
        return new Result();
    }

    /**
     * @description setData()
     * @param: msg
     * @date: 2022/7/27 21:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    public Result setData(Object data) {
        put("data", data);
        return this;
    }

    /**
     * @description 利用fastjson进行反序列化
     * @param: typeReference
     * @date: 2022/7/27 21:38
     * @return: T
     * @author: xjl
     */
    public <T> T getData(TypeReference<T> typeReference) {
        //默认是map
        Object data = get("data");
        String jsonString = JSON.toJSONString(data);
        T t = JSON.parseObject(jsonString, typeReference);
        return t;
    }

    /**
     * @description 利用fastjson进行反序列化
     * @param: key
     * @param: typeReference
     * @date: 2022/7/27 21:39
     * @return: T
     * @author: xjl
     */
    public <T> T getData(String key, TypeReference<T> typeReference) {
        //默认是map
        Object data = get(key);
        String jsonString = JSON.toJSONString(data);
        T t = JSON.parseObject(jsonString, typeReference);
        return t;
    }

    /**
     * @description put()
     * @param: key
     * @param: value
     * @date: 2022/7/27 21:39
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * @description getCode()
     * @param:
     * @date: 2022/7/27 21:39
     * @return: java.lang.Integer
     * @author: xjl
     */
    public Integer getCode() {
        return (Integer) this.get("code");
    }
}
