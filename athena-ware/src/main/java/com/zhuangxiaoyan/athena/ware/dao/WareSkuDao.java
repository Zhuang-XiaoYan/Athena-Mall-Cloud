package com.zhuangxiaoyan.athena.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.ware.entity.WareSkuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    Long querySkuHasStock(@Param("skuId") Long skuId);

    /**
     * @description 查询所有的库存仓库
      * @param: skuId
     * @date: 2022/9/12 10:31
     * @return: java.util.List<java.lang.Long>
     * @author: xjl
    */
    List<Long> listWareIdHasSkuStock(@Param("skuId") Long skuId);

    /**
     * @description 锁定库存
      * @param: skuId
     * @param: wareId
     * @param: num
     * @date: 2022/9/12 10:48
     * @return: java.lang.Long
     * @author: xjl
    */
    Long lockSkuStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("num") Integer num);

    /**
     * @description 解锁
      * @param: skuId
     * @param: wareId
     * @param: skuNum
     * @date: 2022/9/17 20:50
     * @return: void
     * @author: xjl
    */
    void unLockStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("skuNum") Integer skuNum);
}
