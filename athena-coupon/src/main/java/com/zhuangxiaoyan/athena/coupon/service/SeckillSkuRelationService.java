package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.SeckillSkuRelationEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 秒杀活动商品关联
 * @date: 2022/7/28 16:34
 * @author: xjl
*/
public interface SeckillSkuRelationService extends IService<SeckillSkuRelationEntity> {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:34
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);
}

