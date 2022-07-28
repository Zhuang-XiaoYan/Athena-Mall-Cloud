package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.HomeAdvEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 首页轮播广告
 * @date: 2022/7/28 16:31
 * @author: xjl
*/
public interface HomeAdvService extends IService<HomeAdvEntity> {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:31
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);
}

