package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.BrandEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 品牌
 * @date: 2022/7/28 8:26
 * @author: xjl
 */

public interface BrandService extends IService<BrandEntity> {
    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:43
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description updateDetail
     * @param: brand
     * @date: 2022/7/28 13:44
     * @return: void
     * @author: xjl
     */
    void updateDetail(BrandEntity brand);
}

