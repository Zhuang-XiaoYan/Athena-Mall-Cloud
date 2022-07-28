package com.zhuangxiaoyan.athena.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 商品三级分类接口
 * @param: null
 * @date: 2022/7/28 13:03
 * @return:
 * @author: xjl
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {

}
