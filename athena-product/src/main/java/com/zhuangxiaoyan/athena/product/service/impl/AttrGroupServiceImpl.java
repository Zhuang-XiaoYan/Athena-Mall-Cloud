package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.dao.AttrGroupDao;
import com.zhuangxiaoyan.athena.product.entity.AttrEntity;
import com.zhuangxiaoyan.athena.product.entity.AttrGroupEntity;
import com.zhuangxiaoyan.athena.product.service.AttrGroupService;
import com.zhuangxiaoyan.athena.product.service.AttrService;
import com.zhuangxiaoyan.athena.product.vo.AttrGroupWithAttrsVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description AttrGroupServiceImpl
 * @date: 2022/7/28 13:56
 * @author: xjl
 */

@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    AttrService attrService;

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 13:57
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), new QueryWrapper<AttrGroupEntity>());
        return new PageUtils(page);
    }

    /**
     * @description 查询的catelogId所对应的结果
     * @param: params
     * @param: catelogId
     * @date: 2022/7/22 22:21
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        String key = (String) params.get("key");
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>();
        if (!StringUtil.isEmpty(key)) {
            wrapper.and((object) -> {
                object.eq("attr_group_id", key).or().like("attr_group_name", key);
            });
        }
        // 如果是的0 那就查询所有的分类属性
        if (catelogId == 0) {
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
            return new PageUtils(page);
        } else {
            wrapper.eq("catelog_id", catelogId);
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
            return new PageUtils(page);
        }
    }

    /**
     * @description根据分类id 查询出的所有的分组和这里面的这些属性
     * @param: catelogId
     * @date: 2022/7/25 13:14
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.vo.AttrGroupWithAttrsVo>
     * @author: xjl
     */
    @Override
    public List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
        // 查询分组信息
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));

        // 查询所有的属性
        List<AttrGroupWithAttrsVo> collect = attrGroupEntities.stream().map(group -> {
            AttrGroupWithAttrsVo attrVos = new AttrGroupWithAttrsVo();
            BeanUtils.copyProperties(group, attrVos);
            List<AttrEntity> attrs = attrService.getAttrRelation(attrVos.getAttrGroupId());
            attrVos.setAttrs(attrs);
            return attrVos;
        }).collect(Collectors.toList());
        return collect;
    }
}