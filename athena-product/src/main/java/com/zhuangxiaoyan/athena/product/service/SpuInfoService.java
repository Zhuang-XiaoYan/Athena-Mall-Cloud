package com.zhuangxiaoyan.athena.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuangxiaoyan.athena.product.entity.SpuInfoEntity;
import com.zhuangxiaoyan.athena.product.vo.SpuSaveVo;
import com.zhuangxiaoyan.common.utils.PageUtils;

import java.util.Map;

/**
 * @description spu信息接口
 * @date: 2022/7/28 8:28
 * @author: xjl
 */

public interface SpuInfoService extends IService<SpuInfoEntity> {
    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:51
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * @description saveSpuInfo
     * @param: spuSaveVo
     * @date: 2022/7/28 13:51
     * @return: void
     * @author: xjl
     */
    void saveSpuInfo(SpuSaveVo spuSaveVo);

    /**
     * @description saveBaseSpuInfo
     * @param: spuInfoEntity
     * @date: 2022/7/28 13:51
     * @return: void
     * @author: xjl
     */
    void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity);

    /**
     * @description TODO
     * @param: params
     * @date: 2022/7/28 13:52
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    PageUtils queryPageByCondition(Map<String, Object> params);

    /**
     * @description 保存数据的es中
      * @param: spuId
     * @date: 2022/8/1 21:03
     * @return: void
     * @author: xjl
    */
    void spusavees(Long spuId);
}

