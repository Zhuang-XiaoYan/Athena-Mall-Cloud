package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.AttrEntity;
import com.zhuangxiaoyan.athena.product.entity.AttrGroupEntity;
import com.zhuangxiaoyan.athena.product.service.AttrGroupService;
import com.zhuangxiaoyan.athena.product.service.AttrService;
import com.zhuangxiaoyan.athena.product.service.AttrgroupRelationService;
import com.zhuangxiaoyan.athena.product.service.CategoryService;
import com.zhuangxiaoyan.athena.product.vo.AttrGroupRelationVo;
import com.zhuangxiaoyan.athena.product.vo.AttrGroupWithAttrsVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @description 属性分组
 * @date: 2022/7/28 10:41
 * @return:
 * @author: xjl
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {

    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private AttrgroupRelationService attrgroupRelationService;

    /**
     * @description 获取组的属性
     * @param: catelogId
     * @date: 2022/7/28 10:57
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @GetMapping("/{catelogId}/withattr")
    public Result getAttrGroupWithAttrs(@PathVariable("attrgroupId") Long catelogId) {
        // 查询的当前分类下的所有的属性分组
        // 查询的每一个属性分组的所有的属性
        List<AttrGroupWithAttrsVo> vos = attrGroupService.getAttrGroupWithAttrsByCatelogId(catelogId);
        return Result.ok().put("data", vos);
    }

    /**
     * @description 添加相关属性
     * @param: attrGroupRelationVos
     * @date: 2022/7/28 10:57
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @PostMapping("/attr/relation")
    public Result addRelation(@RequestBody List<AttrGroupRelationVo> attrGroupRelationVos) {
        attrgroupRelationService.saveBatch(attrGroupRelationVos);
        return Result.ok();
    }

    /**
     * @description 属性的相关
     * @param: attrgroupId
     * @date: 2022/7/28 10:58
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @GetMapping("/{attrgroupId}/attr/relation")
    public Result attrRelation(@PathVariable("attrgroupId") Long attrgroupId) {
        List<AttrEntity> entities = attrService.getAttrRelation(attrgroupId);
        return Result.ok().put("data", entities);
    }

    /**
     * @description 查询的没有关联的分组属性
     * @param: null
     * @date: 2022/7/24 16:58
     * @return:
     * @author: xjl
     */
    @GetMapping("/{attrgroupId}/noattr/relation")
    //@RequiresPermissions("product:attr:delete")
    public Result attrNoRelation(@RequestParam Map<String, Object> params, @PathVariable("attrgroupId") Long attrgroupId) {
        PageUtils page = attrService.getNotAttrRelation(params, attrgroupId);
        return Result.ok().put("page", page);
    }

    /**
     * @description 删除分组管理的分组的属性
     * @param: attrGroupRelationVos
     * @date: 2022/7/24 16:57
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @PostMapping("/attr/realation/delete")
    //@RequiresPermissions("product:attr:delete")
    public Result deleteRelation(@RequestBody AttrGroupRelationVo[] attrGroupRelationVos) {
        attrService.deleteRelation(attrGroupRelationVos);
        return Result.ok();
    }

    /**
     * @description 查询属性列表
     * @param: params
     * @param: catelogId
     * @date: 2022/7/28 10:58
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list/{catelogId}")
    //@RequiresPermissions("product:attrgroup:list")
    public Result list(@RequestParam Map<String, Object> params, @PathVariable("catelogId") Long catelogId) {
        PageUtils page = attrGroupService.queryPage(params, catelogId);
        return Result.ok().put("page", page);
    }

    /**
     * @description 查询的catelogId的完整的路径
     * @param: attrGroupId
     * @date: 2022/7/28 10:59
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public Result info(@PathVariable("attrGroupId") Long attrGroupId) {
        AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        Long[] path = categoryService.findCateglogPath(catelogId);
        attrGroup.setCatelogpath(path);
        return Result.ok().put("attrGroup", attrGroup);
    }

    /**
     * @description 简单保存
     * @param: attrGroup
     * @date: 2022/7/28 10:59
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public Result save(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.save(attrGroup);
        return Result.ok();
    }

    /**
     * @description 简单更新
     * @param: attrGroup
     * @date: 2022/7/28 10:59
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public Result update(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.updateById(attrGroup);
        return Result.ok();
    }

    /**
     * @description 简单删除操作
     * @param: attrGroupIds
     * @date: 2022/7/28 10:59
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public Result delete(@RequestBody Long[] attrGroupIds) {
        attrGroupService.removeByIds(Arrays.asList(attrGroupIds));
        return Result.ok();
    }

}
