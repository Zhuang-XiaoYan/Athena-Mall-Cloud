package com.zhuangxiaoyan.athena.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description spu信息介绍模型类
 * @date: 2022/7/28 13:14
 * @return:
 * @author: xjl
 */

@Data
@TableName("pms_spu_info_desc")
public class SpuInfoDescEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(type = IdType.INPUT)
    private Long spuId;

    /**
     * 商品介绍
     */
    private String decript;

}
