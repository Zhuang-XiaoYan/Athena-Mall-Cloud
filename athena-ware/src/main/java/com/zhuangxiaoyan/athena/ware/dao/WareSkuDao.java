package com.zhuangxiaoyan.athena.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.ware.entity.WareSkuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description 商品库存
 * @date: 2022/7/30 23:56
 * @author: xjl
 */

@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {

    /**
     * @description 添加到库存中
      * @param: skuId
     * @param: wareId
     * @param: skuNum
     * @date: 2022/8/1 23:02
     * @return: void
     * @author: xjl
    */
    void addStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("skuNum") Integer skuNum);

    /**
     * @description 查询是否有库存
      * @param: skuId
     * @date: 2022/8/1 23:02
     * @return: java.lang.Long
     * @author: xjl
    */
    Long getSkuStock(Long skuId);
}
