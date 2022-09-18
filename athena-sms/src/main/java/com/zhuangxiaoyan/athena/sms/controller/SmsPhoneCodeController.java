package com.zhuangxiaoyan.athena.sms.controller;

import com.zhuangxiaoyan.athena.sms.config.SmsConfig;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SmsPhoneCodeController
 * @Description TODO
 * @Date 2022/8/21 18:30
 *@author: xjl
 */
@RequestMapping("/sms")
@RestController
public class SmsPhoneCodeController {

    @Autowired
    SmsConfig smsConfig;

    /**
     * @description 提供系统的其他服务的调用
     * @param: phone
     * @param: code
     * @date: 2022/8/21 18:33
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @GetMapping("/sendcode")
    public Result sendPhoneCode(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        System.out.println("发送的phone:"+phone);
        System.out.println("发送的code是:" + code);
        smsConfig.sengSmsCode(phone, code);
        return Result.ok();
    }
}
