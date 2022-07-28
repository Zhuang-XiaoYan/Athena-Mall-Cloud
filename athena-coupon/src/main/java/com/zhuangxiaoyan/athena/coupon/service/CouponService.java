package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.CouponEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 优惠券信息
 * @date: 2022/7/28 16:20
 * @author: xjl
*/
public interface CouponService extends IService<CouponEntity> {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:20
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);
}

