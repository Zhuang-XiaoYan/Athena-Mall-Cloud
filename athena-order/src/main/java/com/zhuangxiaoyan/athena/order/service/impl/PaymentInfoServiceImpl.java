package com.zhuangxiaoyan.athena.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.order.dao.PaymentInfoDao;
import com.zhuangxiaoyan.athena.order.entity.PaymentInfoEntity;
import com.zhuangxiaoyan.athena.order.service.PaymentInfoService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description PaymentInfoServiceImpl
 * @date: 2022/7/30 23:41
 * @author: xjl
*/

@Service("paymentInfoService")
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoDao, PaymentInfoEntity> implements PaymentInfoService {

    /**
     * @description 查询
     * @param: params
     * @date: 2022/7/30 23:44
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PaymentInfoEntity> page = this.page(new Query<PaymentInfoEntity>().getPage(params),new QueryWrapper<PaymentInfoEntity>());
        return new PageUtils(page);
    }

}