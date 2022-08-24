package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.constant.ErrorCode;
import com.zhuangxiaoyan.athena.member.entity.MemberEntity;
import com.zhuangxiaoyan.athena.member.exception.PhoneExistException;
import com.zhuangxiaoyan.athena.member.exception.UsernameExistException;
import com.zhuangxiaoyan.athena.member.service.MemberService;
import com.zhuangxiaoyan.athena.member.vo.UserLoginVo;
import com.zhuangxiaoyan.athena.member.vo.UserRegisterVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 会员
 * @date: 2022/7/30 17:40
 * @author: xjl
 */

@RestController
@RequestMapping("member/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/30 21:53
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/30 21:54
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public Result info(@PathVariable("id") Long id) {
        MemberEntity member = memberService.getById(id);
        return Result.ok().put("member", member);
    }

    /**
     * @description 保存数据
     * @param: member
     * @date: 2022/7/30 21:54
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public Result save(@RequestBody MemberEntity member) {
        memberService.save(member);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: member
     * @date: 2022/7/30 21:54
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public Result update(@RequestBody MemberEntity member) {
        memberService.updateById(member);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/30 21:54
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public Result delete(@RequestBody Long[] ids) {
        memberService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
