package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description 商品三级分类
 * @date: 2022/7/28 8:26
 * @author: xjl
 */

public interface CategoryService extends IService<CategoryEntity> {
    /**
     * @description queryPage页查询
     * @param: params
     * @date: 2022/7/28 13:45
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description 查询出所有的分类以及子分类，以及树形结构
     * @param:
     * @date: 2022/3/13 17:37
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.CategoryEntity>
     * @author: xjl
     */
    List<CategoryEntity> listWithTree();

    /**
     * @description removeMenuByIds
     * @param: asList
     * @date: 2022/7/28 13:46
     * @return: void
     * @author: xjl
     */
    void removeMenuByIds(List<Long> asList);

    /**
     * @description 查找的到categoryiD的完整路径 【父 子 …………】
     * @param: categoryId
     * @date: 2022/7/23 8:56
     * @return: java.lang.Long[]
     * @author: xjl
     */
    Long[] findCateglogPath(Long categoryId);

    /**
     * @description updateCascade()
     * @param: category
     * @date: 2022/7/28 13:47
     * @return: void
     * @author: xjl
     */
    void updateCascade(CategoryEntity category);
}

