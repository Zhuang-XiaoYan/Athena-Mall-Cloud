package com.zhuangxiaoyan.athena.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.ware.entity.WareOrderTaskDetailEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:38:27
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

