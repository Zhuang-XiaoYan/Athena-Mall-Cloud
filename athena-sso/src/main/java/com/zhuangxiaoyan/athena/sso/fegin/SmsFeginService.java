package com.zhuangxiaoyan.athena.sso.fegin;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname SmsFeginService
 * @Description TODO
 * @Date 2022/8/21 18:45
 * @Created by xjl
 */
@FeignClient("athena-sms")
public interface SmsFeginService {

    @GetMapping("/sms/sendcode")
    public Result sendPhoneCode(@RequestParam("phone") String phone, @RequestParam("code") String code);
}
