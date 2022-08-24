package com.zhuangxiaoyan.athena.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.member.dao.MemberDao;
import com.zhuangxiaoyan.athena.member.dao.MemberLevelDao;
import com.zhuangxiaoyan.athena.member.entity.MemberEntity;
import com.zhuangxiaoyan.athena.member.entity.MemberLevelEntity;
import com.zhuangxiaoyan.athena.member.exception.PhoneExistException;
import com.zhuangxiaoyan.athena.member.exception.UsernameExistException;
import com.zhuangxiaoyan.athena.member.service.MemberService;
import com.zhuangxiaoyan.athena.member.vo.UserLoginVo;
import com.zhuangxiaoyan.athena.member.vo.UserRegisterVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description MemberServiceImpl
 * @date: 2022/7/30 22:28
 * @author: xjl
 */

@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

    @Autowired
    MemberLevelDao memberLevelDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberEntity> page = this.page(new Query<MemberEntity>().getPage(params), new QueryWrapper<MemberEntity>());
        return new PageUtils(page);
    }

    /**
     * @description checkMobile
     * @param:
     * @date: 2022/8/22 21:33
     * @return: void
     * @author: xjl
     */
    @Override
    public void checkMobile(String Mobile) throws PhoneExistException {
        MemberDao memberDao = this.baseMapper;
        Integer mobile_count = memberDao.selectCount(new QueryWrapper<MemberEntity>().eq("mobile", Mobile));
        if (mobile_count > 0) {
            throw new PhoneExistException();
        }
    }

    /**
     * @description checkUsername
     * @param:
     * @date: 2022/8/22 21:33
     * @return: void
     * @author: xjl
     */
    @Override
    public void checkUsername(String username) throws UsernameExistException {
        MemberDao memberDao = this.baseMapper;
        Integer username_count = memberDao.selectCount(new QueryWrapper<MemberEntity>().eq("username", username));
        if (username_count > 0) {
            throw new UsernameExistException();
        }
    }

    /**
     * @description 用户登入
     * @param: userRegisterVo
     * @date: 2022/8/22 21:33
     * @return: void
     * @author: xjl
     */
    @Override
    public void userRegistry(UserRegisterVo userRegisterVo) {
        MemberEntity memberEntity = new MemberEntity();
        MemberDao memberDao = this.baseMapper;
        MemberLevelEntity memberLevelEntity = memberLevelDao.getDefaultLevel();
        memberEntity.setLevelId(memberLevelEntity.getId());
        // 检查的用户名和手机号的唯一性
        checkMobile(userRegisterVo.getPhone());
        checkUsername(userRegisterVo.getUserName());
        // 验证手机和用户名的唯一性
        memberEntity.setMobile(userRegisterVo.getPhone());
        memberEntity.setUsername(userRegisterVo.getUserName());
        // 密文保存
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode_password = passwordEncoder.encode(userRegisterVo.getPassWord());
        memberEntity.setPassword(encode_password);
        // 保存用户
        memberDao.insert(memberEntity);
    }

    /**
     * @description 用户的登入功能
      * @param: userLoginVo
     * @date: 2022/8/24 8:49
     * @return: com.zhuangxiaoyan.athena.member.entity.MemberEntity
     * @author: xjl
    */
    @Override
    public MemberEntity userLogin(UserLoginVo userLoginVo) {
        String account=userLoginVo.getLoginAccount();
        String password=userLoginVo.getPassWord();

        MemberDao memberDao = this.baseMapper;
        MemberEntity memberEntity = memberDao.selectOne(new QueryWrapper<MemberEntity>().eq("username", account).or().eq("mobile", account));
        if (memberEntity==null){
            //登入失败
            return null;
        }else {
            String dbPassword = memberEntity.getPassword();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean matches = passwordEncoder.matches(password, dbPassword);
            if (matches){
                return memberEntity;
            }else {
                return null;
            }
        }
    }
}