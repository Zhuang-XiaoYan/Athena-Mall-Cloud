package com.zhuangxiaoyan.athena.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.member.dao.MemberLevelDao;
import com.zhuangxiaoyan.athena.member.entity.MemberLevelEntity;
import com.zhuangxiaoyan.athena.member.service.MemberLevelService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description MemberLevelServiceImpl
 * @date: 2022/7/30 22:24
 * @author: xjl
 */

@Service("memberLevelService")
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelDao, MemberLevelEntity> implements MemberLevelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberLevelEntity> page = this.page(new Query<MemberLevelEntity>().getPage(params), new QueryWrapper<MemberLevelEntity>());
        return new PageUtils(page);
    }

}