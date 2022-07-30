package com.zhuangxiaoyan.athena.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.member.dao.MemberCollectSubjectDao;
import com.zhuangxiaoyan.athena.member.entity.MemberCollectSubjectEntity;
import com.zhuangxiaoyan.athena.member.service.MemberCollectSubjectService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description MemberCollectSubjectServiceImpl
 * @date: 2022/7/30 22:24
 * @author: xjl
 */

@Service("memberCollectSubjectService")
public class MemberCollectSubjectServiceImpl extends ServiceImpl<MemberCollectSubjectDao, MemberCollectSubjectEntity> implements MemberCollectSubjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberCollectSubjectEntity> page = this.page(new Query<MemberCollectSubjectEntity>().getPage(params), new QueryWrapper<MemberCollectSubjectEntity>());
        return new PageUtils(page);
    }

}