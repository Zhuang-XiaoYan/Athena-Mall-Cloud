package com.zhuangxiaoyan.athena.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.product.entity.AttrgroupRelationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @description 属性&属性分组关联
 * @date: 2022/7/28 12:52
 * @return:
 * @author: xjl
 */
@Mapper
public interface AttrgroupRelationDao extends BaseMapper<AttrgroupRelationEntity> {

    void deleteBatchRealtion(@PathVariable("entities") List<AttrgroupRelationEntity> entities);
}
