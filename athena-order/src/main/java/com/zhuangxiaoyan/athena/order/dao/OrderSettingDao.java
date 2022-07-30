package com.zhuangxiaoyan.athena.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.order.entity.OrderSettingEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 订单配置信息
 * @date: 2022/7/30 23:28
 * @author: xjl
*/

@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {

}
