package com.zhuangxiaoyan.athena.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuangxiaoyan.athena.product.entity.SkuSaleAttrValueEntity;
import com.zhuangxiaoyan.athena.product.vo.SkuItemSaleAttrVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description sku销售属性&值接口
 * @param: null
 * @date: 2022/7/28 13:04
 * @return:
 * @author: xjl
 */
@Mapper
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValueEntity> {

    List<SkuItemSaleAttrVo> getSaleAttrBySpuId(@Param("spuId") Long spuId);

    List<String> getSkuSaleAttrValuesStringList(@Param("skuId") Long skuId);
}
