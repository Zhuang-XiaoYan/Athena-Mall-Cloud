package com.zhuangxiaoyan.athena.coupon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.coupon.entity.HomeSubjectEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * @date: 2022/7/28 16:03
 * @author: xjl
 */

@Mapper
public interface HomeSubjectDao extends BaseMapper<HomeSubjectEntity> {

}
