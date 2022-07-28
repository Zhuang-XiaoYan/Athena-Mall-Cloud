package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.MemberPriceEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 商品会员价格
 * @date: 2022/7/28 16:32
 * @author: xjl
*/
public interface MemberPriceService extends IService<MemberPriceEntity> {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:32
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);
}

