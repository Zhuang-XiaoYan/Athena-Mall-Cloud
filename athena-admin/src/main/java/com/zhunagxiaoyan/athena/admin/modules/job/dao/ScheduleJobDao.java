package com.zhunagxiaoyan.athena.admin.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhunagxiaoyan.athena.admin.modules.job.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @description 定时任务
 * @date: 2022/7/30 13:03
 * @author: xjl
*/

@Mapper
public interface ScheduleJobDao extends BaseMapper<ScheduleJobEntity> {

    /**
     * 批量更新状态
     */
    int updateBatch(Map<String, Object> map);
}
