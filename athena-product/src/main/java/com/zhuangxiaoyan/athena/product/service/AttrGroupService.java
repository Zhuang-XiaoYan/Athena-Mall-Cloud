package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.AttrGroupEntity;
import com.zhuangxiaoyan.athena.product.vo.AttrGroupWithAttrsVo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description 属性分组
 * @date: 2022/7/28 8:25
 * @author: xjl
 */

public interface AttrGroupService extends IService<AttrGroupEntity> {
    /**
     * @description 页查询
     * @param: params
     * @date: 2022/7/28 8:29
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description 查询bycatelogId
     * @param: params
     * @param: catelogId
     * @date: 2022/7/28 8:30
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params, Long catelogId);

    /**
     * @description 通过的分类ID获取分组属性
     * @param: catelogId
     * @date: 2022/7/28 8:31
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.vo.AttrGroupWithAttrsVo>
     * @author: xjl
     */
    List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId);
}

