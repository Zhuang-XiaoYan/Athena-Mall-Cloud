package com.zhuangxiaoyan.athena.ware.to;

import lombok.Data;

/**
 * @description 仓库详情传输对象
 * @date: 2022/3/19 18:34
 * @author: xjl
 */

@Data
public class StockDetailTo {

    /**
     * id
     */
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
