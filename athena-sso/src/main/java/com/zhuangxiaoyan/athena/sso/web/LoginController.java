package com.zhuangxiaoyan.athena.sso.web;

import com.zhuangxiaoyan.athena.sso.constant.ErrorCode;
import com.zhuangxiaoyan.athena.sso.constant.SsoConstant;
import com.zhuangxiaoyan.athena.sso.fegin.SmsFeginService;
import com.zhuangxiaoyan.common.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Classname loginController
 * @Description TODO
 * @Date 2022/8/21 18:36
 * @Created by xjl
 */
@Controller
public class LoginController {

    @Autowired
    SmsFeginService smsFeginService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @GetMapping("/sso/sendcode")
    public Result sendPhoneCode(@RequestParam("phone") String phone) {

        String rediscode = stringRedisTemplate.opsForValue().get(SsoConstant.SMS_CODE_CACHE_PREFIX + phone);
        if (!StringUtils.isEmpty(rediscode)){
            long redis_time = Long.parseLong(rediscode.split("_")[1]);
            if (System.currentTimeMillis() - redis_time < 60000) {
                //60秒内不能在发送相关的验证码
                return Result.error(ErrorCode.SMS_CODE_EXCEPTION.getCode(),ErrorCode.SMS_CODE_EXCEPTION.getMessage());
            }
        }
        String code = UUID.randomUUID().toString().substring(0, 5) + "_" + System.currentTimeMillis();
        // 接口防止刷机

        // 缓存的验证码
        stringRedisTemplate.opsForValue().set(SsoConstant.SMS_CODE_CACHE_PREFIX + phone, code, 10, TimeUnit.MINUTES);
        smsFeginService.sendPhoneCode(phone, code);
        return Result.ok();
    }
}
