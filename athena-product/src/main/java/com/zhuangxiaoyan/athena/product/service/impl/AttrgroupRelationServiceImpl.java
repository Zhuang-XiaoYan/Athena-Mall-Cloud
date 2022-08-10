package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.AttrgroupRelationDao;
import com.zhuangxiaoyan.athena.product.entity.AttrgroupRelationEntity;
import com.zhuangxiaoyan.athena.product.service.AttrgroupRelationService;
import com.zhuangxiaoyan.athena.product.vo.AttrGroupRelationVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description AttrgroupRelationServiceImpl
 * @date: 2022/7/28 13:53
 * @author: xjl
 */

@Service("AttrgroupRelationService")
public class AttrgroupRelationServiceImpl extends ServiceImpl<AttrgroupRelationDao, AttrgroupRelationEntity> implements AttrgroupRelationService {

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:53
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrgroupRelationEntity> page = this.page(new Query<AttrgroupRelationEntity>().getPage(params), new QueryWrapper<AttrgroupRelationEntity>());
        return new PageUtils(page);
    }

    /**
     * @description saveBatch
     * @param: attrGroupRelationVos
     * @date: 2022/7/28 13:53
     * @return: void
     * @author: xjl
     */
    @Override
    public void saveBatch(List<AttrGroupRelationVo> attrGroupRelationVos) {
        List<AttrgroupRelationEntity> collect = attrGroupRelationVos.stream().map(item -> {
            AttrgroupRelationEntity attrgroupRelationEntity = new AttrgroupRelationEntity();
            BeanUtils.copyProperties(item, attrgroupRelationEntity);
            return attrgroupRelationEntity;
        }).collect(Collectors.toList());
        // 批量保存的方式
        this.saveBatch(collect);
    }
}