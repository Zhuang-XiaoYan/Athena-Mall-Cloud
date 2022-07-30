package com.zhuangxiaoyan.athena.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.member.dao.GrowthChangeHistoryDao;
import com.zhuangxiaoyan.athena.member.entity.GrowthChangeHistoryEntity;
import com.zhuangxiaoyan.athena.member.service.GrowthChangeHistoryService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description GrowthChangeHistoryServiceImpl
 * @date: 2022/7/30 22:21
 * @author: xjl
 */

@Service("growthChangeHistoryService")
public class GrowthChangeHistoryServiceImpl extends ServiceImpl<GrowthChangeHistoryDao, GrowthChangeHistoryEntity> implements GrowthChangeHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GrowthChangeHistoryEntity> page = this.page(new Query<GrowthChangeHistoryEntity>().getPage(params), new QueryWrapper<GrowthChangeHistoryEntity>());
        return new PageUtils(page);
    }

}