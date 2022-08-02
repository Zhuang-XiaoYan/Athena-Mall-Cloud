package com.zhuangxiaoyan.athena.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.ware.entity.WareSkuEntity;
import com.zhuangxiaoyan.athena.ware.vo.SkuHasStockVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description 商品库存
 * @date: 2022/7/31 0:02
 * @author: xjl
 */

public interface WareSkuService extends IService<WareSkuEntity> {
    /**
     * @description 分页查询
      * @param: params
     * @date: 2022/8/1 22:56
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description 添加到这个仓库
      * @param: skuId
     * @param: wareId
     * @param: skuNum
     * @date: 2022/8/1 22:56
     * @return: void
     * @author: xjl
    */
    void addStock(Long skuId, Long wareId, Integer skuNum);

    /**
     * @description 查询是否有库存
      * @param: skuIds
     * @date: 2022/8/1 22:57
     * @return: java.util.List<com.zhuangxiaoyan.athena.ware.vo.SkuHasStockVo>
     * @author: xjl
    */
    List<SkuHasStockVo> querySkuHasStock(@Param("skuIds") List<Long> skuIds);
}

