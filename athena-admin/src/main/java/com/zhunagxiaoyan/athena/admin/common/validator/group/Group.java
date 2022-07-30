

package com.zhunagxiaoyan.athena.admin.common.validator.group;

import javax.validation.GroupSequence;

/**
 * @description 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 * @date: 2022/7/30 8:52
 * @author: xjl
*/
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {

}
