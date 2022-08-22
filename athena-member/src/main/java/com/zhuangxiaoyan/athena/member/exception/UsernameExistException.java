package com.zhuangxiaoyan.athena.member.exception;

/**
 * @Classname UsernameExistException
 * @Description TODO
 * @Date 2022/8/22 21:45
 * @Created by xjl
 */
public class UsernameExistException extends RuntimeException {

    public UsernameExistException() {
        super("用户名已经存在");
    }
}
