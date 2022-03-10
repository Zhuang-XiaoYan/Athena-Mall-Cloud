package com.zhuangxiaoyan.athena.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.order.entity.OrderSettingEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {

}
