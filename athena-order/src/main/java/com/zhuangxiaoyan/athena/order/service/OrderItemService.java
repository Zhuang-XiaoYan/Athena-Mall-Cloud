package com.zhuangxiaoyan.athena.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.order.entity.OrderItemEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

