package com.zhuangxiaoyan.athena.coupon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.coupon.entity.CouponHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 优惠券领取历史记录
 * @date: 2022/7/28 16:03
 * @author: xjl
 */

@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {

}
