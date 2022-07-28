package com.zhuangxiaoyan.athena.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 优惠券分类关联
 * @date: 2022/7/28 16:15
 * @author: xjl
 */
@Data
@TableName("sms_coupon_spu_category_relation")
public class CouponSpuCategoryRelationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 优惠券id
     */
    private Long couponId;
    /**
     * 产品分类id
     */
    private Long categoryId;
    /**
     * 产品分类名称
     */
    private String categoryName;

}
