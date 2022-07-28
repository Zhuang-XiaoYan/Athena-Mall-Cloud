package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.SeckillPromotionDao;
import com.zhuangxiaoyan.athena.coupon.entity.SeckillPromotionEntity;
import com.zhuangxiaoyan.athena.coupon.service.SeckillPromotionService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description SeckillPromotionServiceImpl
 * @date: 2022/7/28 16:36
 * @return:
 * @author: xjl
 */

@Service("seckillPromotionService")
public class SeckillPromotionServiceImpl extends ServiceImpl<SeckillPromotionDao, SeckillPromotionEntity> implements SeckillPromotionService {

    /**
     * @description 分页查询
     * @param: params
     * @date: 2022/7/28 16:42
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeckillPromotionEntity> page = this.page(new Query<SeckillPromotionEntity>().getPage(params), new QueryWrapper<SeckillPromotionEntity>());
        return new PageUtils(page);
    }
}