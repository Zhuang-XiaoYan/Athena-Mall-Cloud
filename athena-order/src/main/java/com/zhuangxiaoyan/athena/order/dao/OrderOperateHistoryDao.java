package com.zhuangxiaoyan.athena.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.order.entity.OrderOperateHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@Mapper
public interface OrderOperateHistoryDao extends BaseMapper<OrderOperateHistoryEntity> {

}
