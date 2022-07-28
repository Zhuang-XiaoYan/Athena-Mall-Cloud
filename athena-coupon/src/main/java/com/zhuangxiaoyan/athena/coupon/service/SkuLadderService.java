package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.SkuLadderEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 商品阶梯价格
 * @date: 2022/7/28 16:35
 * @author: xjl
*/
public interface SkuLadderService extends IService<SkuLadderEntity> {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:35
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    PageUtils queryPage(Map<String, Object> params);
}

