package com.zhuangxiaoyan.common.to.mq;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description TODO
 * @param: null
 * @date: 2022/3/19 18:34
 * @return:
 * @author: xjl
 */
@Data
public class SeckillOrderTo {

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 活动场次id
     */
    private Long promotionSessionId;
    /**
     * 商品id
     */
    private Long skuId;
    /**
     * 秒杀价格
     */
    private BigDecimal seckillPrice;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 会员ID
     */
    private Long memberId;

}
