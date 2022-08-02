package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.constant.ProductConstant;
import com.zhuangxiaoyan.athena.product.dao.AttrDao;
import com.zhuangxiaoyan.athena.product.dao.AttrGroupDao;
import com.zhuangxiaoyan.athena.product.dao.AttrgroupRelationDao;
import com.zhuangxiaoyan.athena.product.dao.CategoryDao;
import com.zhuangxiaoyan.athena.product.entity.AttrEntity;
import com.zhuangxiaoyan.athena.product.entity.AttrGroupEntity;
import com.zhuangxiaoyan.athena.product.entity.AttrgroupRelationEntity;
import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.athena.product.service.AttrService;
import com.zhuangxiaoyan.athena.product.service.CategoryService;
import com.zhuangxiaoyan.athena.product.vo.AttrGroupRelationVo;
import com.zhuangxiaoyan.athena.product.vo.AttrRespVo;
import com.zhuangxiaoyan.athena.product.vo.AttrVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description AttrServiceImpl
 * @date: 2022/7/28 14:06
 * @author: xjl
 */

@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    CategoryService categoryService;

    @Autowired
    private AttrgroupRelationDao attrgroupRelationDao;

    @Autowired
    private AttrGroupDao attrGroupDao;

    @Autowired
    private CategoryDao categoryDao;

    /**
     * @description queryPage
     * @param: params
     * @date: 2022/7/28 14:06
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(new Query<AttrEntity>().getPage(params), new QueryWrapper<AttrEntity>());
        return new PageUtils(page);
    }

    /**
     * @description saveAttrVo
     * @param: attr
     * @date: 2022/7/28 14:06
     * @return: void
     * @author: xjl
     */
    @Override
    public void saveAttrVo(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        // 保存基本的数据库中
        this.save(attrEntity);
        // 保存关联关系
        if (attr.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode() && attr.getAttrGroupId() != null) {
            AttrgroupRelationEntity attrgroupRelationEntity = new AttrgroupRelationEntity();
            attrgroupRelationEntity.setAttrGroupId(attr.getAttrGroupId());
            attrgroupRelationEntity.setAttrId(attr.getAttrId());
            attrgroupRelationDao.insert(attrgroupRelationEntity);
        }
    }

    /**
     * @description queryBaseAttrQuery
     * @param: params
     * @param: catelogId
     * @param: attrType
     * @date: 2022/7/28 14:06
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryBaseAttrQuery(Map<String, Object> params, Long catelogId, String attrType) {
        QueryWrapper<AttrEntity> attrEntityQueryWrapper = new QueryWrapper<AttrEntity>().eq("attr_type", "base".equalsIgnoreCase(attrType) ? ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode() : ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode());
        if (catelogId != 0) {
            attrEntityQueryWrapper.eq("catelog_id", catelogId);
        }
        String key = (String) params.get("key");
        if (!StringUtil.isEmpty(key)) {
            attrEntityQueryWrapper.and((wapper) -> {
                wapper.eq("attr_id", key).or().like("attr_name", key);
            });
        }
        IPage<AttrEntity> page = this.page(new Query<AttrEntity>().getPage(params), attrEntityQueryWrapper);
        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrRespVo> respVos = records.stream().map((attrEntity) -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(attrEntity, attrRespVo);
            // 设置分类和分组
            if ("base".equalsIgnoreCase(attrType)) {
                AttrgroupRelationEntity attr_id = attrgroupRelationDao.selectOne(new QueryWrapper<AttrgroupRelationEntity>().eq("attr_id", attrEntity.getAttrId()));
                if (attr_id != null && attr_id.getAttrGroupId() != null) {
                    AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attr_id.getAttrGroupId());
                    attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
                }
            }
            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
            if (categoryEntity != null) {
                attrRespVo.setCatelogName(categoryEntity.getName());
            }
            return attrRespVo;
        }).collect(Collectors.toList());
        pageUtils.setList(respVos);
        return pageUtils;
    }

    /**
     * @description getAttrInfo
     * @param: attrId
     * @date: 2022/7/28 14:07
     * @return: com.zhuangxiaoyan.athena.product.vo.AttrRespVo
     * @author: xjl
     */
    @Override
    public AttrRespVo getAttrInfo(Long attrId) {
        AttrRespVo attrRespVo = new AttrRespVo();
        AttrEntity attrEntity = this.getById(attrId);
        BeanUtils.copyProperties(attrEntity, attrRespVo);
        if (attrEntity.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()) {
            // 设置分组信息
            AttrgroupRelationEntity attrgroupRelation = attrgroupRelationDao.selectOne(new QueryWrapper<AttrgroupRelationEntity>().eq("attr_id", attrId));
            if (attrgroupRelation != null) {
                attrRespVo.setAttrGroupId(attrgroupRelation.getAttrGroupId());
                AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrgroupRelation.getAttrGroupId());
                if (attrGroupEntity != null) {
                    attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
                }
            }
        }
        // 设置分类信息
        Long catelogId = attrEntity.getCatelogId();
        Long[] categlogPath = categoryService.findCateglogPath(catelogId);
        attrRespVo.setCatelogPath(categlogPath);
        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        if (categoryEntity != null) {
            attrRespVo.setCatelogName(categoryEntity.getName());
        }
        return attrRespVo;
    }

    /**
     * @description updateAttr
     * @param: attrVo
     * @date: 2022/7/28 14:08
     * @return: void
     * @author: xjl
     */
    @Transactional(rollbackFor = Exception.class, timeout = 30)
    @Override
    public void updateAttr(AttrVo attrVo) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attrVo, attrEntity);
        this.updateById(attrEntity);
        if (attrEntity.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()) {
            // 修改关联分组信息
            AttrgroupRelationEntity attrgroupRelationEntity = new AttrgroupRelationEntity();
            attrgroupRelationEntity.setAttrGroupId(attrVo.getAttrGroupId());
            attrgroupRelationEntity.setAttrId(attrVo.getAttrId());
            // 查询是否的属性
            Integer count = attrgroupRelationDao.selectCount(new QueryWrapper<AttrgroupRelationEntity>().eq("attr_id", attrVo.getAttrId()));
            if (count > 0) {
                // 修改分组关联
                attrgroupRelationDao.update(attrgroupRelationEntity, new UpdateWrapper<AttrgroupRelationEntity>().eq("attr_id", attrVo.getAttrId()));
            } else {
                // 新增操作
                attrgroupRelationDao.insert(attrgroupRelationEntity);
            }
        }
    }

    /**
     * @description 根据分组id查找关联的所有的基本属性
     * @param: attrgroupId
     * @date: 2022/7/24 16:17
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.AttrEntity>
     * @author: xjl
     */
    @Override
    public List<AttrEntity> getAttrRelation(Long attrgroupId) {
        List<AttrgroupRelationEntity> entities = attrgroupRelationDao.selectList(new QueryWrapper<AttrgroupRelationEntity>().eq("attr_group_id", attrgroupId));
        List<Long> attrIds = entities.stream().map((attr) -> {
            return attr.getAttrId();
        }).collect(Collectors.toList());
        if (attrIds == null || attrIds.size() == 0) {
            return null;
        }
        Collection<AttrEntity> attrEntities = this.listByIds(attrIds);
        return (List<AttrEntity>) attrEntities;
    }

    /**
     * @description deleteRelation
     * @param: attrGroupRelationVos
     * @date: 2022/7/28 14:08
     * @return: void
     * @author: xjl
     */
    @Override
    public void deleteRelation(AttrGroupRelationVo[] attrGroupRelationVos) {
        List<AttrgroupRelationEntity> entities = Arrays.asList(attrGroupRelationVos).stream().map((item) -> {
            AttrgroupRelationEntity attrgroupRelationEntity = new AttrgroupRelationEntity();
            BeanUtils.copyProperties(item, attrgroupRelationEntity);
            return attrgroupRelationEntity;
        }).collect(Collectors.toList());
        // 批量的删除的关联关系
        attrgroupRelationDao.deleteBatchRealtion(entities);
    }

    /**
     * @description 获取当前分组没有关联的属性
     * @param: params
     * @param: attrgroupId
     * @date: 2022/7/24 17:20
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils getNotAttrRelation(Map<String, Object> params, Long attrgroupId) {
        // 当前的分组只能关联自己所属的分类的的所有属性
        AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrgroupId);
        Long catelogId = attrGroupEntity.getCatelogId();
        // 当前分支只能关联的分组没有引用的属性
        // 当前分类下的其他分组、
        List<AttrGroupEntity> groupEntities = attrGroupDao.selectList(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));
        List<Long> collect = groupEntities.stream().map(item -> {
            return item.getAttrGroupId();
        }).collect(Collectors.toList());
        // 这些分组的关联属性
        List<AttrgroupRelationEntity> group_id = attrgroupRelationDao.selectList(new QueryWrapper<AttrgroupRelationEntity>().in("attr_group_id", collect));
        List<Long> attrIds = group_id.stream().map(item -> {
            return item.getAttrId();
        }).collect(Collectors.toList());
        // 从当前分类的所有的属性中移除这些属性，即为没有关联的属性
        QueryWrapper<AttrEntity> QueryWrapper = new QueryWrapper<AttrEntity>().eq("catelog_id", catelogId);
        if (attrIds != null && attrIds.size() > 0) {
            QueryWrapper.notIn("attr_id", attrIds);
        }
        String key = (String) params.get("key");
        if (!StringUtil.isEmpty(key)) {
            QueryWrapper.and((wrapper) -> {
                wrapper.eq("attr_id", key).or().like("attr_name", key);
            });
        }
        IPage<AttrEntity> page = this.page(new Query<AttrEntity>().getPage(params), QueryWrapper);
        PageUtils pageUtils = new PageUtils(page);
        return pageUtils;
    }

    /**
     * @description 在制定的所有的属性集合中里面 ，挑选出检索属性
      * @param: attrIds
     * @date: 2022/8/1 21:54
     * @return: java.util.List<java.lang.Long>
     * @author: xjl
    */
    @Override
    public List<Long> selectSearchAttrs(List<Long> attrIds) {
        return baseMapper.selectSearchAttrs(attrIds);
    }
}