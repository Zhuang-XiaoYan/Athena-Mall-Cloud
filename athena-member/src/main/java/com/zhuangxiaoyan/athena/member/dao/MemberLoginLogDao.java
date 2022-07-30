package com.zhuangxiaoyan.athena.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.member.entity.MemberLoginLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 会员登录记录
 * @date: 2022/7/30 17:42
 * @author: xjl
*/

@Mapper
public interface MemberLoginLogDao extends BaseMapper<MemberLoginLogEntity> {

}
