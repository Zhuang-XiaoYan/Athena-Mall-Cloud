package com.zhuangxiaoyan.athena.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.ware.entity.WareOrderTaskEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:38:27
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

