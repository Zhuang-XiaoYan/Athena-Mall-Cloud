package com.zhuangxiaoyan.athena.sso.web;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname LogoutController
 * @Description TODO
 * @Date 2022/9/1 21:15
 *@author: xjl
 */
@Controller
public class LogoutController {

    @GetMapping("/logout")
    public Result logout(){
        // 删除的redis的相关数据

        // 删除当前的cookie的数据

        return Result.ok();
    }
}
