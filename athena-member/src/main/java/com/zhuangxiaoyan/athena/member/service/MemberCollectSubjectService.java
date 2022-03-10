package com.zhuangxiaoyan.athena.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.member.entity.MemberCollectSubjectEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 21:59:29
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

