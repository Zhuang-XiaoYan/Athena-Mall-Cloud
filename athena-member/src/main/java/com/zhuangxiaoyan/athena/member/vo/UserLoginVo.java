package com.zhuangxiaoyan.athena.member.vo;

import lombok.Data;

/**
 * @description TODO
 * @param: null
 * @date: 2022/8/21 21:49
 * @return:
 * @author: xjl
 */

@Data
public class UserLoginVo {
    /**
     * @description 登入账户
     */
    private String loginAccount;

    /**
     * @description 登入密码
     */
    private String passWord;
}
