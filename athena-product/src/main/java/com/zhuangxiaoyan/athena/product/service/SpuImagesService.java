package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.SpuImagesEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description spu图片接口
 * @date: 2022/7/28 8:28
 * @author: xjl
 */

public interface SpuImagesService extends IService<SpuImagesEntity> {
    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:50
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description saveImages
     * @param: id
     * @param: images
     * @date: 2022/7/28 13:50
     * @return: void
     * @author: xjl
     */
    void saveImages(Long id, List<String> images);
}

