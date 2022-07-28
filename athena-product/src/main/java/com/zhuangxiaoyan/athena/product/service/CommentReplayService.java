package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.CommentReplayEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 商品评价回复关系
 * @date: 2022/7/28 8:26
 * @author: xjl
 */

public interface CommentReplayService extends IService<CommentReplayEntity> {
    /**
     * @description queryPage()
     * @param: params
     * @date: 2022/7/28 13:48
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);
}

