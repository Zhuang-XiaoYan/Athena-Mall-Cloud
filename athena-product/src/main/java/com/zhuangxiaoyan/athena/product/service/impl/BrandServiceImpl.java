package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.BrandDao;
import com.zhuangxiaoyan.athena.product.entity.BrandEntity;
import com.zhuangxiaoyan.athena.product.service.BrandService;
import com.zhuangxiaoyan.athena.product.service.CategoryBrandRelationService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @description BrandServiceImpl
 * @date: 2022/7/28 14:14
 * @author: xjl
 */

@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 14:09
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> Wrapper = new QueryWrapper<>();
        if (!StringUtil.isEmpty(key)) {
            // 使用字段的模糊查询
            Wrapper.eq("brand_id", key).or().like("name", key);
        }
        IPage<BrandEntity> page = this.page(new Query<BrandEntity>().getPage(params), Wrapper);
        return new PageUtils(page);
    }

    /**
     * @description updateDetail
     * @param: brand
     * @date: 2022/7/28 14:09
     * @return: void
     * @author: xjl
     */
    @Transactional(rollbackFor = Exception.class, timeout = 30)
    @Override
    public void updateDetail(BrandEntity brand) {
        // 冗余数据字段的额一致性
        this.updateById(brand);
        if (!StringUtil.isEmpty(brand.getName())) {
            // 同步更新其他的关联的数据表
            categoryBrandRelationService.updateBrand(brand.getBrandId(), brand.getName());
            // 更新其他的关联数据
        }
    }
}