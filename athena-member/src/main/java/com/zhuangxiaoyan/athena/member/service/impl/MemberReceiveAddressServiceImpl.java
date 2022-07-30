package com.zhuangxiaoyan.athena.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.member.dao.MemberReceiveAddressDao;
import com.zhuangxiaoyan.athena.member.entity.MemberReceiveAddressEntity;
import com.zhuangxiaoyan.athena.member.service.MemberReceiveAddressService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description MemberReceiveAddressServiceImpl
 * @date: 2022/7/30 22:28
 * @author: xjl
 */

@Service("memberReceiveAddressService")
public class MemberReceiveAddressServiceImpl extends ServiceImpl<MemberReceiveAddressDao, MemberReceiveAddressEntity> implements MemberReceiveAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberReceiveAddressEntity> page = this.page(new Query<MemberReceiveAddressEntity>().getPage(params), new QueryWrapper<MemberReceiveAddressEntity>());
        return new PageUtils(page);
    }

}