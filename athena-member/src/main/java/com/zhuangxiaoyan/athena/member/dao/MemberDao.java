package com.zhuangxiaoyan.athena.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 会员
 * @date: 2022/7/30 17:42
 * @author: xjl
*/
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {

}
