package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.SpuInfoDescEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description spu信息介绍接口
 * @date: 2022/7/28 8:28
 * @author: xjl
 */

public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {
    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:50
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description queryPage
     * @param: descEntity
     * @date: 2022/7/28 13:51
     * @return: void
     * @author: xjl
     */
    void saveSpuInforDescript(SpuInfoDescEntity descEntity);
}

