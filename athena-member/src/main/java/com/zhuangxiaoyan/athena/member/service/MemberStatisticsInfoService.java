package com.zhuangxiaoyan.athena.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.member.entity.MemberStatisticsInfoEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * 会员统计信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 21:59:28
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

