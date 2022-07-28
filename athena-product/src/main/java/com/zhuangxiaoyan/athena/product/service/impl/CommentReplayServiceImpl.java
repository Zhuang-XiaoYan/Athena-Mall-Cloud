package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.CommentReplayDao;
import com.zhuangxiaoyan.athena.product.entity.CommentReplayEntity;
import com.zhuangxiaoyan.athena.product.service.CommentReplayService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description CommentReplayServiceImpl
 * @date: 2022/7/28 14:13
 * @author: xjl
 */

@Service("commentReplayService")
public class CommentReplayServiceImpl extends ServiceImpl<CommentReplayDao, CommentReplayEntity> implements CommentReplayService {

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 14:12
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommentReplayEntity> page = this.page(new Query<CommentReplayEntity>().getPage(params), new QueryWrapper<CommentReplayEntity>());
        return new PageUtils(page);
    }
}