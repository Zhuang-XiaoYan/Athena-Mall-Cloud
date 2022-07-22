package com.zhuangxiaoyan.athena.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.ware.entity.PurchaseEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * 采购信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:38:27
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

