package com.zhuangxiaoyan.athena.sso.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname EmployessController
 * @Description 需要登入才能訪访问
 * @Date 2022/8/28 16:15
 *@author: xjl
 */

@Controller
public class EmployessController {

    @GetMapping(value = "/employees")
    public String employees(Model model,HttpSession session,@RequestParam(value = "token", required = false) String token) {
        if (!StringUtils.isEmpty(token)){
            session.setAttribute("loginUser","zhangsan");
        }

        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            // 如果的没有登入 跳转到登入服务器进行登入
            return "redirect:" + "http://localhost:8083/login.html"+"?redirect_url=http://localhost:8081/employees";
        } else {
            List<String> emps = new ArrayList<>();
            emps.add("张三");
            emps.add("李四");
            model.addAttribute("emps", emps);
            return "employees";
        }
    }
}
