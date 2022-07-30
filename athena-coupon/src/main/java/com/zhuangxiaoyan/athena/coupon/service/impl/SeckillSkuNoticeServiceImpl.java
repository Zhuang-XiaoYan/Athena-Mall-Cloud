package com.zhuangxiaoyan.athena.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.coupon.dao.SeckillSkuNoticeDao;
import com.zhuangxiaoyan.athena.coupon.entity.SeckillSkuNoticeEntity;
import com.zhuangxiaoyan.athena.coupon.service.SeckillSkuNoticeService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description SeckillSkuNoticeServiceImpl
 * @date: 2022/7/28 16:36
 * @author: xjl
 */

@Service("seckillSkuNoticeService")
public class SeckillSkuNoticeServiceImpl extends ServiceImpl<SeckillSkuNoticeDao, SeckillSkuNoticeEntity> implements SeckillSkuNoticeService {

    /**
     * @description 分页查询
     * @param: params
     * @date: 2022/7/28 16:40
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeckillSkuNoticeEntity> page = this.page(new Query<SeckillSkuNoticeEntity>().getPage(params), new QueryWrapper<SeckillSkuNoticeEntity>());
        return new PageUtils(page);
    }

}