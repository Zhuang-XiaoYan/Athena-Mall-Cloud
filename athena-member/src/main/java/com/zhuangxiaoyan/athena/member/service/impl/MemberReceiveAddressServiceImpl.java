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

import java.util.List;
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

    /**
     * @description 获取会员的地址
      * @param: memberId
     * @date: 2022/9/6 15:34
     * @return: java.util.List<com.zhuangxiaoyan.athena.member.entity.MemberReceiveAddressEntity>
     * @author: xjl
    */
    @Override
    public List<MemberReceiveAddressEntity> getAddress(Long memberId) {
        List<MemberReceiveAddressEntity> addreslist = this.list(new QueryWrapper<MemberReceiveAddressEntity>().eq("member_id", memberId));
        return addreslist;
    }

}