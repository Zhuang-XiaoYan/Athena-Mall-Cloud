package com.zhuangxiaoyan.common.to.mq;

import lombok.Data;

/**
 * @description TODO
 * @param: null
 * @date: 2022/3/19 18:34
 * @return:
 * @author: xjl
 */

@Data
public class StockDetailTo {

    private Long id;
    /**
     * sku_id
     */
    private Long skuId;
    /**
     * sku_name
     */
    private String skuName;
    /**
     * 购买个数
     */
    private Integer skuNum;
    /**
     * 工作单id
     */
    private Long taskId;

    /**
     * 仓库id
     */
    private Long wareId;

    /**
     * 锁定状态
     */
    private Integer lockStatus;

}
