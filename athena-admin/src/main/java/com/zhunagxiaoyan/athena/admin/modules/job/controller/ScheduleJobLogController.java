package com.zhunagxiaoyan.athena.admin.modules.job.controller;

import com.zhunagxiaoyan.athena.admin.common.utils.PageUtils;
import com.zhunagxiaoyan.athena.admin.common.utils.Result;
import com.zhunagxiaoyan.athena.admin.modules.job.entity.ScheduleJobLogEntity;
import com.zhunagxiaoyan.athena.admin.modules.job.service.ScheduleJobLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description 定时任务日志
 * @date: 2022/7/30 13:02
 * @author: xjl
*/
@RestController
@RequestMapping("/sys/scheduleLog")
public class ScheduleJobLogController {
    @Autowired
    private ScheduleJobLogService scheduleJobLogService;

    /**
     * 定时任务日志列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:log")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = scheduleJobLogService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 定时任务日志信息
     */
    @RequestMapping("/info/{logId}")
    public Result info(@PathVariable("logId") Long logId) {
        ScheduleJobLogEntity log = scheduleJobLogService.getById(logId);

        return Result.ok().put("log", log);
    }
}
