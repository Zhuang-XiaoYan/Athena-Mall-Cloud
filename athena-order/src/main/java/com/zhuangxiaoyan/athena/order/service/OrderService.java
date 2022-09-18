package com.zhuangxiaoyan.athena.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.order.entity.OrderEntity;
import com.zhuangxiaoyan.athena.order.vo.OrderConfirmVo;
import com.zhuangxiaoyan.athena.order.vo.OrderSubmitVo;
import com.zhuangxiaoyan.athena.order.vo.SubmitOrderResponseVo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @description 订单
 * @date: 2022/7/30 23:37
 * @author: xjl
*/
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description 订单确认返回所需要的数据
      * @param:
     * @date: 2022/9/6 9:11
     * @return: com.zhuangxiaoyan.athena.order.vo.OrderConfirmVo
     * @author: xjl
    */
    OrderConfirmVo confirmOrder() throws ExecutionException, InterruptedException;

    /**
     * @description 下单逻辑
      * @param: vo
     * @date: 2022/9/11 15:50
     * @return: com.zhuangxiaoyan.athena.order.vo.SubmitOrderResponseVo
     * @author: xjl
    */
    SubmitOrderResponseVo submitOrder(OrderSubmitVo vo);

    /**
     * @description 获取订单的状态
      * @param: orderSn
     * @date: 2022/9/17 20:11
     * @return: com.zhuangxiaoyan.athena.order.entity.OrderEntity
     * @author: xjl
    */
    OrderEntity getStatusByOrderSn(String orderSn);

    /**
     * @description 关闭订单
      * @param: orderEntity
     * @date: 2022/9/17 22:15
     * @return: void
     * @author: xjl
    */
    void closeOrder(OrderEntity orderEntity);
}

