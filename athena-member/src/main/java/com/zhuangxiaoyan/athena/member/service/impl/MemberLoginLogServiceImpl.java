package com.zhuangxiaoyan.athena.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.member.dao.MemberLoginLogDao;
import com.zhuangxiaoyan.athena.member.entity.MemberLoginLogEntity;
import com.zhuangxiaoyan.athena.member.service.MemberLoginLogService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description MemberLoginLogServiceImpl
 * @date: 2022/7/30 22:25
 * @author: xjl
 */

@Service("memberLoginLogService")
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogDao, MemberLoginLogEntity> implements MemberLoginLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberLoginLogEntity> page = this.page(new Query<MemberLoginLogEntity>().getPage(params), new QueryWrapper<MemberLoginLogEntity>());
        return new PageUtils(page);
    }

}