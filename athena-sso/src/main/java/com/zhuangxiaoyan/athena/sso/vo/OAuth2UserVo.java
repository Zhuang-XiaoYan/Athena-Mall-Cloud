package com.zhuangxiaoyan.athena.sso.vo;

import lombok.Data;

/**
 * @Classname WeiBoUserVo
 * @Description TODO
 * @Date 2022/8/24 21:21
 *@author: xjl
 */
@SuppressWarnings("ALL")
@Data
public class OAuth2UserVo {

    private String access_token;

    private String remind_in;

    private long expires_in;

    private String uid;

    private String isRealName;
}

