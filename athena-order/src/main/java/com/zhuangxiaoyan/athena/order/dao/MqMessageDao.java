package com.zhuangxiaoyan.athena.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.order.entity.MqMessageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@Mapper
public interface MqMessageDao extends BaseMapper<MqMessageEntity> {

}
