package com.zhuangxiaoyan.athena.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 专题商品
 * @date: 2022/7/28 16:17
 * @author: xjl
 */
@Data
@TableName("sms_home_subject_spu")
public class HomeSubjectSpuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 专题名字
     */
    private String name;
    /**
     * 专题id
     */
    private Long subjectId;
    /**
     * spu_id
     */
    private Long spuId;
    /**
     * 排序
     */
    private Integer sort;

}
