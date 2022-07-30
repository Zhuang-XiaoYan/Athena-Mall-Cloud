package com.zhuangxiaoyan.athena.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.order.entity.PaymentInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 支付信息表
 * @date: 2022/7/30 23:28
 * @author: xjl
*/

@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {

}
