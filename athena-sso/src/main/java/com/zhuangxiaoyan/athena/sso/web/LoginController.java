package com.zhuangxiaoyan.athena.sso.web;


import com.alibaba.fastjson.TypeReference;
import com.zhuangxiaoyan.athena.sso.fegin.MemberFeginService;
import com.zhuangxiaoyan.athena.sso.vo.UserLoginVo;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname loginController
 * @Description TODO
 * @Date 2022/8/21 18:36
 * @Created by xjl
 */
@Controller
public class LoginController {

    @Autowired
    MemberFeginService memberFeginService;

    @PostMapping("/login")
    public String login(UserLoginVo userLoginVo, RedirectAttributes redirectAttributes){

        Result result = memberFeginService.login(userLoginVo);
        if (result.getCode()==0){
            // 登入成功 重定向到的首页
            return "redirect:http://athena.com";
        }else {
            Map<String, String> errors=new HashMap();
            errors.put("msg",result.getData("msg",new TypeReference<String>(){}));
            redirectAttributes.addFlashAttribute("errors",errors);
            // 登入失败重新定向到登入页
            return "redirect:http://sso.athena.com/login.html";
        }
    }
}
