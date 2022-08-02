package com.zhuangxiaoyan.athena.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.product.entity.AttrEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 商品属性接口
 * @date: 2022/7/28 12:52
 * @return:
 * @author: xjl
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {

    /**
     * @description 在制定的所有的属性集合中里面 ，挑选出检索属性
      * @param: attrIds
     * @date: 2022/8/1 21:57
     * @return: java.util.List<java.lang.Long>
     * @author: xjl
    */
    List<Long> selectSearchAttrs(@Param("attrIds") List<Long> attrIds);
}
