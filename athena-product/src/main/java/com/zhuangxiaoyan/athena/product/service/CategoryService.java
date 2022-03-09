package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

