package com.zhuangxiaoyan.athena.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 属性&属性分组关联
 * @date: 2022/7/28 13:09
 * @author: xjl
 */

@Data
@TableName("pms_attrgroup_relation")
public class AttrgroupRelationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 属性id
     */
    private Long attrId;

    /**
     * 属性分组id
     */
    private Long attrGroupId;

    /**
     * 属性组内排序
     */
    private Integer attrSort;

}
