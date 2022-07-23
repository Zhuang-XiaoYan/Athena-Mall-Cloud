package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.entity.IntegrationChangeHistoryEntity;
import com.zhuangxiaoyan.athena.member.service.IntegrationChangeHistoryService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 21:59:29
 */
@RestController
@RequestMapping("member/integrationchangehistory")
public class IntegrationChangeHistoryController {
    @Autowired
    private IntegrationChangeHistoryService integrationChangeHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:integrationchangehistory:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = integrationChangeHistoryService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:integrationchangehistory:info")
    public Result info(@PathVariable("id") Long id) {
        IntegrationChangeHistoryEntity integrationChangeHistory = integrationChangeHistoryService.getById(id);

        return Result.ok().put("integrationChangeHistory", integrationChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:integrationchangehistory:save")
    public Result save(@RequestBody IntegrationChangeHistoryEntity integrationChangeHistory) {
        integrationChangeHistoryService.save(integrationChangeHistory);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:integrationchangehistory:update")
    public Result update(@RequestBody IntegrationChangeHistoryEntity integrationChangeHistory) {
        integrationChangeHistoryService.updateById(integrationChangeHistory);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:integrationchangehistory:delete")
    public Result delete(@RequestBody Long[] ids) {
        integrationChangeHistoryService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
