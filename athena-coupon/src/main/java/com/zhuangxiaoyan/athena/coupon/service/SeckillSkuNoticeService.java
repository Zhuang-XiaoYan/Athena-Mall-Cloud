package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.SeckillSkuNoticeEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 秒杀商品通知订阅
 * @date: 2022/7/28 16:33
 * @author: xjl
*/
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:34
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);
}

