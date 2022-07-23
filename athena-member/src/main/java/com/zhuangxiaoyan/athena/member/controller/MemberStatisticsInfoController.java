package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.entity.MemberStatisticsInfoEntity;
import com.zhuangxiaoyan.athena.member.service.MemberStatisticsInfoService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 会员统计信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 21:59:28
 */
@RestController
@RequestMapping("member/memberstatisticsinfo")
public class MemberStatisticsInfoController {
    @Autowired
    private MemberStatisticsInfoService memberStatisticsInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberstatisticsinfo:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberStatisticsInfoService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberstatisticsinfo:info")
    public Result info(@PathVariable("id") Long id) {
        MemberStatisticsInfoEntity memberStatisticsInfo = memberStatisticsInfoService.getById(id);

        return Result.ok().put("memberStatisticsInfo", memberStatisticsInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberstatisticsinfo:save")
    public Result save(@RequestBody MemberStatisticsInfoEntity memberStatisticsInfo) {
        memberStatisticsInfoService.save(memberStatisticsInfo);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:memberstatisticsinfo:update")
    public Result update(@RequestBody MemberStatisticsInfoEntity memberStatisticsInfo) {
        memberStatisticsInfoService.updateById(memberStatisticsInfo);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberstatisticsinfo:delete")
    public Result delete(@RequestBody Long[] ids) {
        memberStatisticsInfoService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
