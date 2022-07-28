package com.zhuangxiaoyan.common.to;

import lombok.Data;

/**
 * @description 发送消息到MQ中
 * @date: 2022/3/19 18:34
 * @author: xjl
 */

@Data
public class StockLockedTo {

    /**
     * 库存工作单的id
     **/
    private Long id;

    /**
     * 工作单详情的所有信息
     **/
    private StockDetailTo detailTo;
}
