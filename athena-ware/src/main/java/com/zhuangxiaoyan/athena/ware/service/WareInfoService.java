package com.zhuangxiaoyan.athena.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.ware.entity.WareInfoEntity;
import com.zhuangxiaoyan.athena.ware.vo.FareVo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @description 仓库信息
 * @date: 2022/7/31 0:01
 * @author: xjl
 */

public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    FareVo getFare(Long addrId);
}

