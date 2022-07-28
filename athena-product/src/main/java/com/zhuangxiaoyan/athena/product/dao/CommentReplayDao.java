package com.zhuangxiaoyan.athena.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.product.entity.CommentReplayEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 商品评价回复关系接口
 * @param: null
 * @date: 2022/7/28 12:53
 * @return:
 * @author: xjl
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {

}
