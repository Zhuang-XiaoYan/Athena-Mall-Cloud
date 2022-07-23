package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.entity.MemberLevelEntity;
import com.zhuangxiaoyan.athena.member.service.MemberLevelService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 会员等级
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 21:59:29
 */
@RestController
@RequestMapping("member/memberlevel")
public class MemberLevelController {
    @Autowired
    private MemberLevelService memberLevelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberlevel:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberLevelService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberlevel:info")
    public Result info(@PathVariable("id") Long id) {
        MemberLevelEntity memberLevel = memberLevelService.getById(id);

        return Result.ok().put("memberLevel", memberLevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberlevel:save")
    public Result save(@RequestBody MemberLevelEntity memberLevel) {
        memberLevelService.save(memberLevel);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:memberlevel:update")
    public Result update(@RequestBody MemberLevelEntity memberLevel) {
        memberLevelService.updateById(memberLevel);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberlevel:delete")
    public Result delete(@RequestBody Long[] ids) {
        memberLevelService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
