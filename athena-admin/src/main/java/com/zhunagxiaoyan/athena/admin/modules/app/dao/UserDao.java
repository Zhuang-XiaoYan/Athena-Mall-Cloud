package com.zhunagxiaoyan.athena.admin.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhunagxiaoyan.athena.admin.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 用户
 * @date: 2022/7/30 9:44
 * @author: xjl
*/
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
