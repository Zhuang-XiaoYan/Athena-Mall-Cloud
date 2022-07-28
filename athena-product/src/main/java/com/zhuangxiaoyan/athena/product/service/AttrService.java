package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.AttrEntity;
import com.zhuangxiaoyan.athena.product.vo.AttrGroupRelationVo;
import com.zhuangxiaoyan.athena.product.vo.AttrRespVo;
import com.zhuangxiaoyan.athena.product.vo.AttrVo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description 商品属性
 * @date: 2022/7/28 8:25
 * @author: xjl
 */

public interface AttrService extends IService<AttrEntity> {
    /**
     * @description 页查询
     * @param: params
     * @date: 2022/7/28 8:31
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description 保存的Attr
     * @param: attr
     * @date: 2022/7/28 8:31
     * @return: void
     * @author: xjl
     */
    void saveAttrVo(AttrVo attr);

    /**
     * @description queryBaseAttrQuery
     * @param: params
     * @param: catelogId
     * @param: attrType
     * @date: 2022/7/28 8:32
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryBaseAttrQuery(Map<String, Object> params, Long catelogId, String attrType);

    /**
     * @description getAttrInfo
     * @param: attrId
     * @date: 2022/7/28 8:32
     * @return: com.zhuangxiaoyan.athena.product.vo.AttrRespVo
     * @author: xjl
     */
    AttrRespVo getAttrInfo(Long attrId);

    /**
     * @description updateAttr
     * @param: attrVo
     * @date: 2022/7/28 8:32
     * @return: void
     * @author: xjl
     */
    void updateAttr(AttrVo attrVo);

    /**
     * @description getAttrRelation
     * @param: attrgroupId
     * @date: 2022/7/28 8:32
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.AttrEntity>
     * @author: xjl
     */
    List<AttrEntity> getAttrRelation(Long attrgroupId);

    /**
     * @description deleteRelation
     * @param: attrGroupRelationVos
     * @date: 2022/7/28 8:32
     * @return: void
     * @author: xjl
     */
    void deleteRelation(AttrGroupRelationVo[] attrGroupRelationVos);

    /**
     * @description getNotAttrRelation
     * @param: params
     * @param: attrgroupId
     * @date: 2022/7/28 8:32
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils getNotAttrRelation(Map<String, Object> params, Long attrgroupId);
}