package com.zhuangxiaoyan.athena.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description TODO
 * @date: 2022/7/28 14:47
 * @author: xjl
*/
@Data
@ToString
public class SkuItemSaleAttrVo {

    private Long attrId;

    private String attrName;

    private List<AttrValueWithSkuIdVo> attrValues;

}
