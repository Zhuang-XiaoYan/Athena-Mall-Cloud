package com.zhunagxiaoyan.athena.admin.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @description 多数据源
 * @date: 2022/7/30 9:34
 * @author: xjl
*/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicContextHolder.peek();
    }

}
