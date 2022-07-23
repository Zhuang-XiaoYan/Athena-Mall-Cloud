package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.BrandDao;
import com.zhuangxiaoyan.athena.product.entity.BrandEntity;
import com.zhuangxiaoyan.athena.product.service.BrandService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

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
}