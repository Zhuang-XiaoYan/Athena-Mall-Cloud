/**
 * Copyright 2020 bejson.com
 */
package com.zhuangxiaoyan.athena.product.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description SpuSaveVo
 * @date: 2022/7/28 14:46
 * @author: xjl
*/
@Data
public class SpuSaveVo {

    private String spuName;

    private String spuDescription;

    private Long catalogId;

    private Long brandId;

    private BigDecimal weight;

    private int publishStatus;

    private List<String> decript;

    private List<String> images;

    private BoundsVo bounds;

    private List<BaseAttrsVo> baseAttrs;

    private List<SkusVo> skus;

}
