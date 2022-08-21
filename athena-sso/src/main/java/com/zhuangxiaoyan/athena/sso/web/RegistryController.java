package com.zhuangxiaoyan.athena.sso.web;

import com.zhuangxiaoyan.athena.sso.vo.UserRegisterVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Classname RegistryController
 * @Description TODO
 * @Date 2022/8/21 21:45
 * @Created by xjl
 */

@Controller
public class RegistryController {

    @PostMapping("/registry")
    public String registry(@Valid UserRegisterVo userRegisterVo, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            //校验出错，转发到注册页
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            redirectAttributes.addFlashAttribute("errors",errors);
            // 如果后端校验出错，重新跳转到注册页
            return "redirect:http://sso.athena.com/registry.html";
        }
        // 调用远程服务进行注册

        return "redirect:/login.html";
    }

}
