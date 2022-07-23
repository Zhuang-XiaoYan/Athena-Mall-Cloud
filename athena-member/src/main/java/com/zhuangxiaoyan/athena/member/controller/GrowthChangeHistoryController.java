package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.entity.GrowthChangeHistoryEntity;
import com.zhuangxiaoyan.athena.member.service.GrowthChangeHistoryService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 21:59:28
 */
@RestController
@RequestMapping("member/growthchangehistory")
public class GrowthChangeHistoryController {
    @Autowired
    private GrowthChangeHistoryService growthChangeHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:growthchangehistory:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = growthChangeHistoryService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:growthchangehistory:info")
    public Result info(@PathVariable("id") Long id) {
        GrowthChangeHistoryEntity growthChangeHistory = growthChangeHistoryService.getById(id);

        return Result.ok().put("growthChangeHistory", growthChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:growthchangehistory:save")
    public Result save(@RequestBody GrowthChangeHistoryEntity growthChangeHistory) {
        growthChangeHistoryService.save(growthChangeHistory);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:growthchangehistory:update")
    public Result update(@RequestBody GrowthChangeHistoryEntity growthChangeHistory) {
        growthChangeHistoryService.updateById(growthChangeHistory);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:growthchangehistory:delete")
    public Result delete(@RequestBody Long[] ids) {
        growthChangeHistoryService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
