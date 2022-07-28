package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.BrandEntity;
import com.zhuangxiaoyan.athena.product.entity.CategoryBrandRelationEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description 品牌分类关联
 * @date: 2022/7/28 8:26
 * @author: xjl
 */

public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {
    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:44
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description saveDetial
     * @param: categoryBrandRelation
     * @date: 2022/7/28 13:45
     * @return: void
     * @author: xjl
     */
    void saveDetial(CategoryBrandRelationEntity categoryBrandRelation);

    /**
     * @description updateBrand
     * @param: brandId
     * @param: name
     * @date: 2022/7/28 13:45
     * @return: void
     * @author: xjl
     */
    void updateBrand(Long brandId, String name);

    /**
     * @description updateCategory
     * @param: catId
     * @param: name
     * @date: 2022/7/28 13:45
     * @return: void
     * @author: xjl
     */
    void updateCategory(Long catId, String name);

    /**
     * @description getBrandsBycatId
     * @param: catId
     * @date: 2022/7/28 13:45
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.BrandEntity>
     * @author: xjl
     */
    List<BrandEntity> getBrandsBycatId(Long catId);
}

