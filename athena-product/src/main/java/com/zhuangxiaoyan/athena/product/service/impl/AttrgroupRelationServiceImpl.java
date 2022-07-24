package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.AttrgroupRelationDao;
import com.zhuangxiaoyan.athena.product.entity.AttrgroupRelationEntity;
import com.zhuangxiaoyan.athena.product.service.AttrgroupRelationService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("attrAttrgroupRelationService")
public class AttrgroupRelationServiceImpl extends ServiceImpl<AttrgroupRelationDao, AttrgroupRelationEntity> implements AttrgroupRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrgroupRelationEntity> page = this.page(
                new Query<AttrgroupRelationEntity>().getPage(params),
                new QueryWrapper<AttrgroupRelationEntity>()
        );
        return new PageUtils(page);
    }

}