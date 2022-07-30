package com.zhuangxiaoyan.athena.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.order.dao.OrderItemDao;
import com.zhuangxiaoyan.athena.order.entity.OrderItemEntity;
import com.zhuangxiaoyan.athena.order.service.OrderItemService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description OrderItemServiceImpl
 * @date: 2022/7/30 23:39
 * @author: xjl
 */

@Service("orderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItemEntity> implements OrderItemService {

    /**
     * @description 查询
     * @param: params
     * @date: 2022/7/30 23:44
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderItemEntity> page = this.page(new Query<OrderItemEntity>().getPage(params),new QueryWrapper<OrderItemEntity>());
        return new PageUtils(page);
    }

}