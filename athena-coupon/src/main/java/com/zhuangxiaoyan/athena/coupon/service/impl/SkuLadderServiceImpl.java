package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.SkuLadderDao;
import com.zhuangxiaoyan.athena.coupon.entity.SkuLadderEntity;
import com.zhuangxiaoyan.athena.coupon.service.SkuLadderService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description SkuLadderServiceImpl
 * @date: 2022/7/28 16:36
 * @author: xjl
 */

@Service("skuLadderService")
public class SkuLadderServiceImpl extends ServiceImpl<SkuLadderDao, SkuLadderEntity> implements SkuLadderService {

    /**
     * @description queryPage
      * @param: params
     * @date: 2022/7/28 16:38
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuLadderEntity> page = this.page(new Query<SkuLadderEntity>().getPage(params),new QueryWrapper<SkuLadderEntity>());
        return new PageUtils(page);
    }
}