package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.SpuInfoDescDao;
import com.zhuangxiaoyan.athena.product.entity.SpuInfoDescEntity;
import com.zhuangxiaoyan.athena.product.service.SpuInfoDescService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description SpuInfoDescServiceImpl
 * @date: 2022/7/28 14:25
 * @author: xjl
 */

@Service("spuInfoDescService")
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescDao, SpuInfoDescEntity> implements SpuInfoDescService {

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 14:25
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoDescEntity> page = this.page(new Query<SpuInfoDescEntity>().getPage(params), new QueryWrapper<SpuInfoDescEntity>());
        return new PageUtils(page);
    }

    /**
     * @description saveSpuInforDescript
     * @param: descEntity
     * @date: 2022/7/28 14:26
     * @return: void
     * @author: xjl
     */
    @Override
    public void saveSpuInforDescript(SpuInfoDescEntity descEntity) {
        this.baseMapper.insert(descEntity);
    }

}