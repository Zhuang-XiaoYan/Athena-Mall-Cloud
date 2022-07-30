package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.CouponHistoryEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 优惠券领取历史记录
 * @date: 2022/7/28 16:19
 * @author: xjl
*/
public interface CouponHistoryService extends IService<CouponHistoryEntity> {
    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:20
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);
}

