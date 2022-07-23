package com.zhuangxiaoyan.athena.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuangxiaoyan.athena.product.service.CategoryBrandRelationService;
import com.zhuangxiaoyan.athena.product.service.CategoryService;
import com.zhuangxiaoyan.athena.product.dao.CategoryDao;
import com.zhuangxiaoyan.athena.product.entity.CategoryEntity;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Action;
import java.util.*;
import java.util.stream.Collectors;

@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * @description TODO  查询出所有的分类以及子分类，以及树形结构
     * @param:
     * @date: 2022/3/13 17:38
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.CategoryEntity>
     * @author: xjl
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        // 查询出所有的分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        // 组装成为的父子结构返回 找到的所有的以及分类
        // 一级分类
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0).map((menu) -> {
            menu.setChildren(getChildrens(menu, entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return level1Menus;
    }

    /**
     * @description 递归查找所有的子分类
     * @param:
     * @date: 2022/3/13 17:49
     * @return: java.util.List<com.zhuangxiaoyan.athena.product.entity.CategoryEntity>
     * @author: xjl
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            // 1找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            // 进行排序处理
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

    /**
     * @description TODO 检查的删除的菜单 是否被其他地方引用
      * @param: asList
     * @date: 2022/3/19 13:57
     * @return: void
     * @author: xjl
    */
    @Override
    public void removeMenuByIds(List<Long> asList) {
        //逻辑删除 一般不做删除
        baseMapper.deleteBatchIds(asList);
    }
    /**
     * @description 查询的CateglogID的所有的路径
      * @param:
     * @date: 2022/7/22 23:14
     * @return: java.lang.Long[]
     * @author: xjl
     * @param categoryId
    */
    @Override
    public Long[] findCateglogPath(Long categoryId) {
        List<Long> paths=new ArrayList<>();
        List<Long> parentPath = findParentPath(categoryId, paths);
        Collections.reverse(parentPath);
        return parentPath.toArray(new Long[parentPath.size()]);
    }
    /**
     * @description 级联更新所有的关联数据
      * @param: category
     * @date: 2022/7/23 11:27
     * @return: void
     * @author: xjl
    */
    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        // 级联更新
        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());

    }

    private List<Long> findParentPath(Long categoryId,List<Long> paths){
        // 收集当前的节点的id数据
        paths.add(categoryId);
        CategoryEntity byId = this.getById(categoryId);
        if (byId.getParentCid()!=0){
            findParentPath(byId.getParentCid(),paths);
        }
        return paths;
    }
}