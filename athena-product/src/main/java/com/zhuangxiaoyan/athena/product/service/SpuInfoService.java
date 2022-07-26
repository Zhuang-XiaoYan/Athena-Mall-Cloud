package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.SpuInfoDescEntity;
import com.zhuangxiaoyan.athena.product.entity.SpuInfoEntity;
import com.zhuangxiaoyan.athena.product.vo.SpuSaveVo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * spu信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo spuSaveVo);

    void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);
}

