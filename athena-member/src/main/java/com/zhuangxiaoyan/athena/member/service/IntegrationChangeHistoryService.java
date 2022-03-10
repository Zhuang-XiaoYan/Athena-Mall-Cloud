package com.zhuangxiaoyan.athena.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.member.entity.IntegrationChangeHistoryEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 21:59:29
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

