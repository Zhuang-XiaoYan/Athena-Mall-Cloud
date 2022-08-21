package com.zhuangxiaoyan.athena.sms.sms;

import com.zhuangxiaoyan.athena.sms.config.SmsConfig;
import com.zhuangxiaoyan.athena.sms.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname AthenaSmsTest
 * HttpUtils请从https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
 * @Description TODO
 * @Date 2022/8/21 14:25
 * @Created by xjl
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AthenaSmsTest {

    @Autowired
    SmsConfig smsConfig;

    @Test
    public void smsTest() {
        String host = "https://dfsns.market.alicloudapi.com";
        String path = "/data/send_sms";
        String method = "POST";
        String appcode = "a0330cff2c784fc7bca5d9f34768de3d";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("content", "code:1314");
        bodys.put("phone_number", "18bh78");
        bodys.put("template_id", "TPL_0000");

        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void smsconfigTest() {
        smsConfig.sengSmsCode("18279148786", "18bh78");
    }
}
