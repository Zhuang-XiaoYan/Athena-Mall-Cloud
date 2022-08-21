package com.zhuangxiaoyan.athena.sms.config;

import com.zhuangxiaoyan.athena.sms.utils.HttpUtils;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname SmsConfig
 * @Description TODO
 * @Date 2022/8/21 17:11
 * @Created by xjl
 */


@ConfigurationProperties(prefix = "athena.sms")
@Data
@Component
public class SmsConfig {

    private String host;
    private String path;
    private String appCode;
    private String tpl_id;

    /**
     * @description 调用第三方的短信功能发送验证码
      * @param: phone
     * @param: code
     * @date: 2022/8/21 19:01
     * @return: void
     * @author: xjl
    */
    public void sengSmsCode(String phone, String code) {
        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appCode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("content", "code:"+code);
        bodys.put("phone_number", phone);
        bodys.put("template_id", tpl_id);
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //获取response的结果
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
