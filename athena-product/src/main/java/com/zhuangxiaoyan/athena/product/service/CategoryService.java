package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
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

    /**
     * @description TODO 查询出所有的分类以及子分类，以及树形结构
     * @param:
     * @date: 2022/3/13 17:37
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.CategoryEntity>
     * @author: xjl
     */
    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);
    /**
     * @description 查找的到categoryiD的完整路径 【父 子 …………】
      * @param: categoryId
     * @date: 2022/7/23 8:56
     * @return: java.lang.Long[]
     * @author: xjl
    */
    Long[] findCateglogPath(Long categoryId);

    void updateCascade(CategoryEntity category);
}

