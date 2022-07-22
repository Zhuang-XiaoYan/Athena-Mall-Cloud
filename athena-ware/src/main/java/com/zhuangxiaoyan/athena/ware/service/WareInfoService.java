package com.zhuangxiaoyan.athena.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.ware.entity.WareInfoEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:38:27
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

