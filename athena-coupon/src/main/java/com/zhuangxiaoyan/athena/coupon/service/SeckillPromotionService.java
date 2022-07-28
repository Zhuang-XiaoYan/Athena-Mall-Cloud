package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.SeckillPromotionEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 秒杀活动
 * @date: 2022/7/28 16:33
 * @author: xjl
*/
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:33
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);
}

