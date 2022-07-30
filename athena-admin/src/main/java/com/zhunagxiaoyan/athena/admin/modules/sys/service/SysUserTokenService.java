

package com.zhunagxiaoyan.athena.admin.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhunagxiaoyan.athena.admin.common.utils.Result;
import com.zhunagxiaoyan.athena.admin.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    /**
     * 生成token
     *
     * @param userId 用户ID
     */
    Result createToken(long userId);

    /**
     * 退出，修改token值
     *
     * @param userId 用户ID
     */
    void logout(long userId);

}
