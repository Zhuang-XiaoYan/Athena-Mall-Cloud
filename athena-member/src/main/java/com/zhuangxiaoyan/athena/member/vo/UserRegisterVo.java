package com.zhuangxiaoyan.athena.member.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @description TODO
  * @param: null
 * @date: 2022/8/21 21:49
 * @return:
 * @author: xjl
*/

@Data
public class UserRegisterVo {

    private String userName;

    private String passWord;

    private String phone;

    private String code;
}
