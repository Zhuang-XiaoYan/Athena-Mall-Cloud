package com.zhuangxiaoyan.athena.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.product.entity.SpuInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description spu信息接口
 * @param: null
 * @date: 2022/7/28 13:06
 * @return:
 * @author: xjl
 */
@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity> {

    /**
     * @description 更新商品上架的状态
      * @param: spuId
     * @param: code
     * @date: 2022/8/3 10:52
     * @return: void
     * @author: xjl
    */
    void updateSpuStatus(@Param("spuId") Long spuId, @Param("code") int code);
}
