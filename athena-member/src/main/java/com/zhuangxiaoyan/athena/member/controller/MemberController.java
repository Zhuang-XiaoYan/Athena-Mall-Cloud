package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.entity.MemberEntity;
import com.zhuangxiaoyan.athena.member.service.MemberService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 会员
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 21:59:29
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public Result info(@PathVariable("id") Long id) {
        MemberEntity member = memberService.getById(id);
        return Result.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public Result save(@RequestBody MemberEntity member) {
        memberService.save(member);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public Result update(@RequestBody MemberEntity member) {
        memberService.updateById(member);
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public Result delete(@RequestBody Long[] ids) {
        memberService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
