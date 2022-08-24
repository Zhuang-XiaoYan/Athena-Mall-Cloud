package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.constant.ErrorCode;
import com.zhuangxiaoyan.athena.member.exception.PhoneExistException;
import com.zhuangxiaoyan.athena.member.exception.UsernameExistException;
import com.zhuangxiaoyan.athena.member.service.MemberService;
import com.zhuangxiaoyan.athena.member.vo.UserRegisterVo;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname MemberRegistryController
 * @Description 用户注册的功能
 * @Date 2022/8/24 21:35
 * @Created by xjl
 */
@RestController
@RequestMapping("member/user")
public class MemberRegistryController {

    @Autowired
    private MemberService memberService;

    /**
     * @description 用户的注册功能
     * @param: userRegisterVo
     * @date: 2022/8/22 21:08
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @PostMapping("/registry")
    public Result registry(@RequestBody UserRegisterVo userRegisterVo) {
        try {
            memberService.userRegistry(userRegisterVo);
        } catch (PhoneExistException e) {
            return Result.error(ErrorCode.PHONE_EXIST_EXCEPTION.getCode(), ErrorCode.PHONE_EXIST_EXCEPTION.getMessage());
        } catch (UsernameExistException e) {
            return Result.error(ErrorCode.USER_EXIST_EXCEPTION.getCode(), ErrorCode.USER_EXIST_EXCEPTION.getMessage());
        }
        return Result.ok();
    }
}
