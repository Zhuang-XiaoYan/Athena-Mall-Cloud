package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.AttrgroupRelationEntity;
import com.zhuangxiaoyan.athena.product.vo.AttrGroupRelationVo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description 属性&属性分组关联
 * @date: 2022/7/28 8:25
 * @author: xjl
 */

public interface AttrgroupRelationService extends IService<AttrgroupRelationEntity> {
    /**
     * @description 页查询
     * @param: params
     * @date: 2022/7/28 8:29
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description 批量保存
     * @param: attrGroupRelationVos
     * @date: 2022/7/28 8:29
     * @return: void
     * @author: xjl
     */
    void saveBatch(List<AttrGroupRelationVo> attrGroupRelationVos);
}

