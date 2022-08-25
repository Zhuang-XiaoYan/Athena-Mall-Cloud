package com.zhuangxiaoyan.athena.sso.web;

import com.alibaba.fastjson.TypeReference;
import com.zhuangxiaoyan.athena.sso.constant.ErrorCode;
import com.zhuangxiaoyan.athena.sso.constant.SsoConstant;
import com.zhuangxiaoyan.athena.sso.fegin.MemberFeginService;
import com.zhuangxiaoyan.athena.sso.fegin.SmsFeginService;
import com.zhuangxiaoyan.athena.sso.vo.UserRegisterVo;
import com.zhuangxiaoyan.common.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Classname RegistryController
 * @Description TODO
 * @Date 2022/8/21 21:45
 * @Created by xjl
 */

@Controller
public class RegistryController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    SmsFeginService smsFeginService;

    @Autowired
    MemberFeginService memberFeginService;


    @GetMapping("/registry.html")
    public String loginPage(){
        return "registry";
    }


    @ResponseBody
    @GetMapping("/sso/sendcode")
    public Result sendPhoneCode(@RequestParam("phone") String phone) {

        String rediscode = stringRedisTemplate.opsForValue().get(SsoConstant.SMS_CODE_CACHE_PREFIX + phone);
        if (!StringUtils.isEmpty(rediscode)) {
            long redis_time = Long.parseLong(rediscode.split("_")[1]);
            if (System.currentTimeMillis() - redis_time < 60000) {
                //60秒内不能在发送相关的验证码
                return Result.error(ErrorCode.SMS_CODE_EXCEPTION.getCode(), ErrorCode.SMS_CODE_EXCEPTION.getMessage());
            }
        }
        String code = UUID.randomUUID().toString().substring(0, 5);
        String redis_code = code + "_" + System.currentTimeMillis();
        // 接口防止刷机

        // 缓存的验证码
        stringRedisTemplate.opsForValue().set(SsoConstant.SMS_CODE_CACHE_PREFIX + phone, redis_code, 10, TimeUnit.MINUTES);
        smsFeginService.sendPhoneCode(phone, code);
        return Result.ok();
    }

    /**
     * @description 用户注册功能
     * @param: userRegisterVo
     * @param: result
     * @param: redirectAttributes
     * @date: 2022/8/22 23:54
     * @return: java.lang.String
     * @author: xjl
     */
    @PostMapping("/registry")
    public String registry(@Valid UserRegisterVo userRegisterVo, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            //校验出错，转发到注册页
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            redirectAttributes.addFlashAttribute("errors", errors);
            // 如果后端校验出错，重新跳转到注册页
            return "redirect:http://sso.athena.com/registry.html";
        }
        // 校验验证码
        String code = userRegisterVo.getCode();
        String rediscode = stringRedisTemplate.opsForValue().get(SsoConstant.SMS_CODE_CACHE_PREFIX + userRegisterVo.getPhone());
        if (!StringUtils.isEmpty(rediscode)) {
            // 验证码通过
            if (code.equals(rediscode.split("_")[0])) {
                // 删除验证码 令牌机制
                stringRedisTemplate.delete(SsoConstant.SMS_CODE_CACHE_PREFIX + userRegisterVo.getPhone());
                // 在调用远程服务进行注册
                Result res = memberFeginService.registry(userRegisterVo);
                if (res.getCode() == 0) {
                    // 注册成功
                    return "redirect:http://sso.athena.com/login.html";
                } else {
                    Map<String, String> errors = new HashMap<>();
                    errors.put("msg", res.getData("msg",new TypeReference<String>(){}));
                    redirectAttributes.addFlashAttribute("errors", errors);
                    return "redirect:http://sso.athena.com/registry.html";
                }
            } else {
                //校验出错，转发到注册页
                Map<String, String> errors = new HashMap<>();
                errors.put("code", "验证码输入错误");
                redirectAttributes.addFlashAttribute("errors", errors);
                // 如果后端校验出错，重新跳转到注册页
                return "redirect:http://sso.athena.com/registry.html";
            }
        } else {
            //校验出错，转发到注册页
            Map<String, String> errors = new HashMap<>();
            errors.put("code", "验证码输入错误");
            redirectAttributes.addFlashAttribute("errors", errors);
            // 如果后端校验出错，重新跳转到注册页
            return "redirect:http://sso.athena.com/registry.html";
        }
    }
}
