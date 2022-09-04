package com.zhuangxiaoyan.athena.cart.to;

import lombok.Data;

/**
 * @description 用户的信息
  * @param: null
 * @date: 2022/9/3 7:42
 * @return:
 * @author: xjl
*/

@Data
public class UserInfoTo {

    private Long userId;

    private String userKey;

    /**
     * 是否临时用户
     */
    private Boolean tempUser = false;

}
