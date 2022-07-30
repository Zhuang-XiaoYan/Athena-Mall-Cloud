package com.zhuangxiaoyan.athena.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.order.dao.MqMessageDao;
import com.zhuangxiaoyan.athena.order.entity.MqMessageEntity;
import com.zhuangxiaoyan.athena.order.service.MqMessageService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description MqMessageServiceImpl
 * @date: 2022/7/30 23:39
 * @author: xjl
*/

@Service("mqMessageService")
public class MqMessageServiceImpl extends ServiceImpl<MqMessageDao, MqMessageEntity> implements MqMessageService {

    /**
     * @description 查询
      * @param: params
     * @date: 2022/7/30 23:44
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MqMessageEntity> page = this.page(new Query<MqMessageEntity>().getPage(params),new QueryWrapper<MqMessageEntity>());
        return new PageUtils(page);
    }

}