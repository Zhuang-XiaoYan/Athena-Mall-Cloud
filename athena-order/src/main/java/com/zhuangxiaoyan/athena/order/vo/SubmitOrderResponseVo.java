package com.zhuangxiaoyan.athena.order.vo;

import com.zhuangxiaoyan.athena.order.entity.OrderEntity;
import lombok.Data;

/**
 * @description TODO
 * @param: null
 * @date: 2022/9/6 9:03
 * @return:
 * @author: xjl
 */
@Data
public class SubmitOrderResponseVo {

    private OrderEntity order;

    /** 错误状态码 **/
    private Integer code;

}
