package com.zhuangxiaoyan.athena.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description SpuItemAttrGroupVo
 * @date: 2022/7/28 14:47
 * @author: xjl
*/

@Data
@ToString
public class SpuItemAttrGroupVo {

    private String groupName;

    private List<AttrSubVo> attrs;

}
