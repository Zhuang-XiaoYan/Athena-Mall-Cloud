package com.zhuangxiaoyan.athena.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.order.entity.MqMessageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description MqMessageDao
 * @date: 2022/7/30 23:28
 * @author: xjl
*/
@Mapper
public interface MqMessageDao extends BaseMapper<MqMessageEntity> {

}
