package com.zhuangxiaoyan.athena.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.order.dao.OrderReturnReasonDao;
import com.zhuangxiaoyan.athena.order.entity.OrderReturnReasonEntity;
import com.zhuangxiaoyan.athena.order.service.OrderReturnReasonService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description OrderReturnReasonServiceImpl
 * @date: 2022/7/30 23:41
 * @author: xjl
*/

@Service("orderReturnReasonService")
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonDao, OrderReturnReasonEntity> implements OrderReturnReasonService {

    /**
     * @description 查询
     * @param: params
     * @date: 2022/7/30 23:44
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderReturnReasonEntity> page = this.page(new Query<OrderReturnReasonEntity>().getPage(params),new QueryWrapper<OrderReturnReasonEntity>());
        return new PageUtils(page);
    }

}