package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.SpuCommentEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 商品评价接口
 * @date: 2022/7/28 8:28
 * @author: xjl
 */

public interface SpuCommentService extends IService<SpuCommentEntity> {
    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:50
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);
}

