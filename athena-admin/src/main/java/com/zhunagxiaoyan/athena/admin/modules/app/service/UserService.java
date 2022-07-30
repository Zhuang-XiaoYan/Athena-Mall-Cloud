

package com.zhunagxiaoyan.athena.admin.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhunagxiaoyan.athena.admin.modules.app.entity.UserEntity;
import com.zhunagxiaoyan.athena.admin.modules.app.form.LoginForm;

/**
 * @description 用户
 * @date: 2022/7/30 13:01
 * @author: xjl
*/
public interface UserService extends IService<UserEntity> {

    UserEntity queryByMobile(String mobile);

    /**
     * 用户登录
     *
     * @param form 登录表单
     * @return 返回用户ID
     */
    long login(LoginForm form);
}
