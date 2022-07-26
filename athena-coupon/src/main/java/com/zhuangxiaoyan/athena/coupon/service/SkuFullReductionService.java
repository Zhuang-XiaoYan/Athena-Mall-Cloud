package com.zhuangxiaoyan.athena.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.coupon.entity.SkuFullReductionEntity;
import com.zhuangxiaoyan.common.to.SkuReductionTo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo skuReductionTo);
}

