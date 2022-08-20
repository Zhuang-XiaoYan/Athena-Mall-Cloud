package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.SkuSaleAttrValueDao;
import com.zhuangxiaoyan.athena.product.entity.SkuSaleAttrValueEntity;
import com.zhuangxiaoyan.athena.product.service.SkuSaleAttrValueService;
import com.zhuangxiaoyan.athena.product.vo.SkuItemSaleAttrVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description SkuSaleAttrValueServiceImpl
 * @date: 2022/7/28 14:22
 * @author: xjl
 */

@Service("skuSaleAttrValueService")
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueDao, SkuSaleAttrValueEntity> implements SkuSaleAttrValueService {

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 14:21
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuSaleAttrValueEntity> page = this.page(new Query<SkuSaleAttrValueEntity>().getPage(params), new QueryWrapper<SkuSaleAttrValueEntity>());
        return new PageUtils(page);
    }

    /**
     * @description 获取spu的销售属性组合
     * @param: spuId
     * @date: 2022/8/20 16:30
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.vo.SkuItemSaleAttrVo>
     * @author: xjl
     */
    @Override
    public List<SkuItemSaleAttrVo> getSaleAttrBySpuId(Long spuId) {
        SkuSaleAttrValueDao dao = this.baseMapper;
        List<SkuItemSaleAttrVo> voList = dao.getSaleAttrBySpuId(spuId);
        return voList;
    }
}