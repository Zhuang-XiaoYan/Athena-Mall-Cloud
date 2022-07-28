package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.SpuCommentDao;
import com.zhuangxiaoyan.athena.product.entity.SpuCommentEntity;
import com.zhuangxiaoyan.athena.product.service.SpuCommentService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description SpuCommentServiceImpl
 * @date: 2022/7/28 14:22
 * @author: xjl
 */

@Service("spuCommentService")
public class SpuCommentServiceImpl extends ServiceImpl<SpuCommentDao, SpuCommentEntity> implements SpuCommentService {

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 14:22
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuCommentEntity> page = this.page(new Query<SpuCommentEntity>().getPage(params), new QueryWrapper<SpuCommentEntity>());
        return new PageUtils(page);
    }
}