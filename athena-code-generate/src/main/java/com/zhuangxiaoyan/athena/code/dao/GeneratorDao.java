package com.zhuangxiaoyan.athena.code.dao;

import java.util.List;
import java.util.Map;

/**
 * @description 数据库接口
 * @date: 2022/7/29 12:11
 * @author: xjl
 */
public interface GeneratorDao {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
