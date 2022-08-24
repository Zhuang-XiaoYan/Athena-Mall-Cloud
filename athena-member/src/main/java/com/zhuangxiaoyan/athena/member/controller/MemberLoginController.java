package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.constant.ErrorCode;
import com.zhuangxiaoyan.athena.member.entity.MemberEntity;
import com.zhuangxiaoyan.athena.member.service.MemberService;
import com.zhuangxiaoyan.athena.member.vo.UserLoginVo;
import com.zhuangxiaoyan.athena.member.vo.WeiBoUserVo;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname MemberLoginController
 * @Description 用户登入的功能
 * @Date 2022/8/24 21:33
 * @Created by xjl
 */
@RestController
@RequestMapping("member/user")
public class MemberLoginController {

    @Autowired
    private MemberService memberService;

    /**
     * @description 用户的账户和密码门的登入
     * @param: userLoginVo
     * @date: 2022/8/24 8:46
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginVo userLoginVo) {
        MemberEntity memberEntity = memberService.userLogin(userLoginVo);
        if (memberEntity!=null){
            return Result.ok();
        }else {
            return Result.error(ErrorCode.LOGINACCT_PASSWORD_EXCEPTION.getCode(),ErrorCode.LOGINACCT_PASSWORD_EXCEPTION.getMessage());
        }
    }

    @PostMapping("/weibo/login")
    public Result weiboLogin(@RequestBody WeiBoUserVo weiBoUserVo) throws Exception {
        MemberEntity memberEntity = memberService.weiboLogin(weiBoUserVo);
        if (memberEntity!=null){
            return Result.ok().setData(memberEntity);
        }else {
            return Result.error(ErrorCode.LOGINACCT_PASSWORD_EXCEPTION.getCode(),ErrorCode.LOGINACCT_PASSWORD_EXCEPTION.getMessage());
        }
    }
}
