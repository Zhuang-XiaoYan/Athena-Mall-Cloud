package com.zhuangxiaoyan.athena.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.order.entity.OrderItemEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 订单项信息
 * @date: 2022/7/30 23:27
 * @author: xjl
*/

@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {

}
