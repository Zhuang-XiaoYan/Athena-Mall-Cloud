package com.zhunagxiaoyan.athena.admin.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhunagxiaoyan.athena.admin.modules.job.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 定时任务日志
 * @date: 2022/7/30 13:03
 * @author: xjl
*/
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {

}
