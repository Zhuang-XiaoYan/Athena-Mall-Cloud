package com.zhuangxiaoyan.athena.sso.fegin;

import com.zhuangxiaoyan.athena.sso.vo.UserLoginVo;
import com.zhuangxiaoyan.athena.sso.vo.UserRegisterVo;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Classname MemberFeginService
 * @Description TODO
 * @Date 2022/8/22 23:39
 * @Created by xjl
 */

@FeignClient("athena-member")
public interface MemberFeginService {

    @PostMapping("/member/member/registry")
    Result registry(@RequestBody UserRegisterVo userRegisterVo);

    @PostMapping("/member/member/login")
    Result login(@RequestBody UserLoginVo userLoginVo);

}
