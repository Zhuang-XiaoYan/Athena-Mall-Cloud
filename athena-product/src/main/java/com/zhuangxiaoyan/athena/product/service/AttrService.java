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
 * 商品属性
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrQuery(Map<String, Object> params, Long catelogId,String attrType);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attrVo);

    List<AttrEntity> getAttrRelation(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] attrGroupRelationVos);

    PageUtils getNotAttrRelation(Map<String, Object> params, Long attrgroupId);
}

