package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.SkuImagesDao;
import com.zhuangxiaoyan.athena.product.entity.SkuImagesEntity;
import com.zhuangxiaoyan.athena.product.service.SkuImagesService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("skuImagesService")
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesDao, SkuImagesEntity> implements SkuImagesService {

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 14:20
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuImagesEntity> page = this.page(new Query<SkuImagesEntity>().getPage(params), new QueryWrapper<SkuImagesEntity>());
        return new PageUtils(page);
    }

    /**
     * @description 通过的skuid获取商品的sku图片信息
      * @param: skuId
     * @date: 2022/8/20 15:54
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.SkuImagesEntity>
     * @author: xjl
    */
    @Override
    public List<SkuImagesEntity> getImagesBySkuId(Long skuId) {
        SkuImagesDao imagesDao = this.baseMapper;
        List<SkuImagesEntity> imagesEntities = imagesDao.selectList(new QueryWrapper<SkuImagesEntity>().eq("sku_id", skuId));
        return imagesEntities;
    }
}