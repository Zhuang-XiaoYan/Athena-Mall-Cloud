package com.zhuangxiaoyan.athena.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.member.entity.MemberEntity;
import com.zhuangxiaoyan.athena.member.exception.PhoneExistException;
import com.zhuangxiaoyan.athena.member.exception.UsernameExistException;
import com.zhuangxiaoyan.athena.member.vo.UserLoginVo;
import com.zhuangxiaoyan.athena.member.vo.UserRegisterVo;
import com.zhuangxiaoyan.athena.member.vo.OAuth2UserVo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description 会员
 * @date: 2022/7/30 22:20
 * @author: xjl
 */

public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description 检查用手机号
     * @param:
     * @date: 2022/8/22 21:32
     * @return: void
     * @author: xjl
     */
    void checkMobile(String Mobile) throws PhoneExistException;

    /**
     * @description 检查用户名
     * @param:
     * @date: 2022/8/22 21:32
     * @return: void
     * @author: xjl
     */
    void checkUsername(String username) throws UsernameExistException;

    /**
     * @description 用户的注册功能
      * @param: userRegisterVo
     * @date: 2022/8/22 21:11
     * @return: void
     * @author: xjl
    */
    void userRegistry(UserRegisterVo userRegisterVo);

    /**
     * @description 用户的登入功能
      * @param: userLoginVo
     * @date: 2022/8/24 8:48
     * @return: com.zhuangxiaoyan.athena.member.entity.MemberEntity
     * @author: xjl
    */
    MemberEntity userLogin(UserLoginVo userLoginVo);

    /**
     * @description t通过微博进行登入
      * @param: weiBoUserVo
     * @date: 2022/8/24 21:43
     * @return: com.zhuangxiaoyan.athena.member.entity.MemberEntity
     * @author: xjl
    */
    MemberEntity weiboLogin(OAuth2UserVo oAuth2UserVo) throws Exception;
}

