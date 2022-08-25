package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.constant.ErrorCode;
import com.zhuangxiaoyan.athena.member.entity.MemberEntity;
import com.zhuangxiaoyan.athena.member.service.MemberService;
import com.zhuangxiaoyan.athena.member.vo.OAuth2UserVo;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname MemberOAuth2Controller
 * @Description TODO
 * @Date 2022/8/25 15:37
 * @Created by xjl
 */

@RestController
@RequestMapping("member/oauth2")
public class MemberOAuth2Controller {

    @Autowired
    private MemberService memberService;

    @PostMapping("/weibo/login")
    public Result weiboLogin(@RequestBody OAuth2UserVo oAuth2UserVo) throws Exception {
        MemberEntity memberEntity = memberService.weiboLogin(oAuth2UserVo);
        if (memberEntity!=null){
            return Result.ok().setData(memberEntity);
        }else {
            return Result.error(ErrorCode.LOGINACCT_PASSWORD_EXCEPTION.getCode(),ErrorCode.LOGINACCT_PASSWORD_EXCEPTION.getMessage());
        }
    }
}
