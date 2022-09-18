package com.zhuangxiaoyan.athena.member.exception;

/**
 * @Classname PhoneExistException
 * @Description TODO
 * @Date 2022/8/22 21:47
 *@author: xjl
 */
public class PhoneExistException extends RuntimeException {

    public PhoneExistException() {
        super("手机号已经存在");
    }
}
