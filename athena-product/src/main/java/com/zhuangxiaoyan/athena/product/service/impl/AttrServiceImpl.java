package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.zhuangxiaoyan.athena.product.dao.AttrDao;
import com.zhuangxiaoyan.athena.product.dao.AttrgroupRelationDao;
import com.zhuangxiaoyan.athena.product.entity.AttrEntity;
import com.zhuangxiaoyan.athena.product.entity.AttrgroupRelationEntity;
import com.zhuangxiaoyan.athena.product.service.AttrService;
import com.zhuangxiaoyan.athena.product.vo.AttrVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private AttrgroupRelationDao attrgroupRelationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity=new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);
        // 保存基本的数据库中
        this.save(attrEntity);
        // 保存关联关系
        AttrgroupRelationEntity attrgroupRelationEntity=new AttrgroupRelationEntity();
        attrgroupRelationEntity.setAttrGroupId(attr.getAttrGroupId());
        attrgroupRelationEntity.setAttrId(attr.getAttrId());
        attrgroupRelationDao.insert(attrgroupRelationEntity);
    }
}