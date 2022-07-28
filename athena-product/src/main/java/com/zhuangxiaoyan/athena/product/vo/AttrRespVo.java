package com.zhuangxiaoyan.athena.product.vo;

import lombok.Data;

/**
 * @description AttrRespVo
 * @date: 2022/7/28 14:44
 * @author: xjl
*/

@Data
public class AttrRespVo extends AttrVo {

    private String catelogName;

    private String groupName;

    private Long[] catelogPath;

}
