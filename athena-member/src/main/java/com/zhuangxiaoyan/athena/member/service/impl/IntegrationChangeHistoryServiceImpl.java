package com.zhuangxiaoyan.athena.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.member.dao.IntegrationChangeHistoryDao;
import com.zhuangxiaoyan.athena.member.entity.IntegrationChangeHistoryEntity;
import com.zhuangxiaoyan.athena.member.service.IntegrationChangeHistoryService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description IntegrationChangeHistoryServiceImpl
 * @date: 2022/7/30 22:23
 * @author: xjl
 */

@Service("integrationChangeHistoryService")
public class IntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryDao, IntegrationChangeHistoryEntity> implements IntegrationChangeHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IntegrationChangeHistoryEntity> page = this.page(new Query<IntegrationChangeHistoryEntity>().getPage(params), new QueryWrapper<IntegrationChangeHistoryEntity>());
        return new PageUtils(page);
    }

}