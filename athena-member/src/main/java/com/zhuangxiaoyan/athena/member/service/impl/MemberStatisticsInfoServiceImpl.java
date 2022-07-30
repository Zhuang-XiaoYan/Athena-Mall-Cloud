package com.zhuangxiaoyan.athena.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.member.dao.MemberStatisticsInfoDao;
import com.zhuangxiaoyan.athena.member.entity.MemberStatisticsInfoEntity;
import com.zhuangxiaoyan.athena.member.service.MemberStatisticsInfoService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description MemberStatisticsInfoServiceImpl
 * @date: 2022/7/30 22:29
 * @author: xjl
 */

@Service("memberStatisticsInfoService")
public class MemberStatisticsInfoServiceImpl extends ServiceImpl<MemberStatisticsInfoDao, MemberStatisticsInfoEntity> implements MemberStatisticsInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberStatisticsInfoEntity> page = this.page(new Query<MemberStatisticsInfoEntity>().getPage(params), new QueryWrapper<MemberStatisticsInfoEntity>());
        return new PageUtils(page);
    }

}