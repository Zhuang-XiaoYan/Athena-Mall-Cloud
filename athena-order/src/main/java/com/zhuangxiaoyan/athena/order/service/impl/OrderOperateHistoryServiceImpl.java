package com.zhuangxiaoyan.athena.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.order.dao.OrderOperateHistoryDao;
import com.zhuangxiaoyan.athena.order.entity.OrderOperateHistoryEntity;
import com.zhuangxiaoyan.athena.order.service.OrderOperateHistoryService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description OrderOperateHistoryServiceImpl
 * @date: 2022/7/30 23:39
 * @author: xjl
 */

@Service("orderOperateHistoryService")
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryDao, OrderOperateHistoryEntity> implements OrderOperateHistoryService {

    /**
     * @description 查询
     * @param: params
     * @date: 2022/7/30 23:44
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderOperateHistoryEntity> page = this.page(new Query<OrderOperateHistoryEntity>().getPage(params),new QueryWrapper<OrderOperateHistoryEntity>());
        return new PageUtils(page);
    }

}