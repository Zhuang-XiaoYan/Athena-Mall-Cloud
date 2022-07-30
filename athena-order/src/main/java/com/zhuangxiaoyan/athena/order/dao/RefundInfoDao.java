package com.zhuangxiaoyan.athena.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.order.entity.RefundInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 退款信息
 * @date: 2022/7/30 23:29
 * @author: xjl
*/

@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfoEntity> {

}
