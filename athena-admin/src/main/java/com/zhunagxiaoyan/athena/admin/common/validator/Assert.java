package com.zhunagxiaoyan.athena.admin.common.validator.group;

import com.zhunagxiaoyan.athena.admin.common.exception.AthenaException;
import org.apache.commons.lang.StringUtils;

/**
 * @description 数据校验
 * @date: 2022/7/30 8:54
 * @author: xjl
*/
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new AthenaException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new AthenaException(message);
        }
    }
}
