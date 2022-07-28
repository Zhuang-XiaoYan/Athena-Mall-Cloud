package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.SpuBoundsEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 商品spu积分设置
 * @date: 2022/7/28 16:35
 * @author: xjl
*/
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    /**
     * @description 商品spu积分设置
      * @param: params
     * @date: 2022/7/28 16:36
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);
}

