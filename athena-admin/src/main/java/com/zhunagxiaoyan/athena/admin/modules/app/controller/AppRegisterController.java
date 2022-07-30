

package com.zhunagxiaoyan.athena.admin.modules.app.controller;

import com.zhunagxiaoyan.athena.admin.common.utils.Result;
import com.zhunagxiaoyan.athena.admin.common.validator.group.ValidatorUtils;
import com.zhunagxiaoyan.athena.admin.modules.app.entity.UserEntity;
import com.zhunagxiaoyan.athena.admin.modules.app.form.RegisterForm;
import com.zhunagxiaoyan.athena.admin.modules.app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description 注册
 * @date: 2022/7/30 9:44
 * @return:
 * @author: xjl
*/
@RestController
@RequestMapping("/app")
@Api("APP注册接口")
public class AppRegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ApiOperation("注册")
    public Result register(@RequestBody RegisterForm form) {
        //表单校验
        ValidatorUtils.validateEntity(form);
        UserEntity user = new UserEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getMobile());
        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        user.setCreateTime(new Date());
        userService.save(user);
        return Result.ok();
    }
}
