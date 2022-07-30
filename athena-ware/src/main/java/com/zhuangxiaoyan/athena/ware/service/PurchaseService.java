package com.zhuangxiaoyan.athena.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.ware.entity.PurchaseEntity;
import com.zhuangxiaoyan.athena.ware.vo.MergeVo;
import com.zhuangxiaoyan.athena.ware.vo.PurchaseDoneVo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @description 采购信息
 * @date: 2022/7/31 0:00
 * @author: xjl
 */

public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageUnrecaive(Map<String, Object> params);

    void merge(MergeVo mergeVo);

    void received(List<Long> ids);

    void done(PurchaseDoneVo purchaseDoneVo);
}

