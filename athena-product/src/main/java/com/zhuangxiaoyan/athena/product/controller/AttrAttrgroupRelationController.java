package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.AttrAttrgroupRelationEntity;
import com.zhuangxiaoyan.athena.product.service.AttrAttrgroupRelationService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attrattrgrouprelation:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrAttrgroupRelationService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:attrattrgrouprelation:info")
    public Result info(@PathVariable("id") Long id) {
        AttrAttrgroupRelationEntity attrAttrgroupRelation = attrAttrgroupRelationService.getById(id);

        return Result.ok().put("attrAttrgroupRelation", attrAttrgroupRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrattrgrouprelation:save")
    public Result save(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation) {
        attrAttrgroupRelationService.save(attrAttrgroupRelation);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrattrgrouprelation:update")
    public Result update(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation) {
        attrAttrgroupRelationService.updateById(attrAttrgroupRelation);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrattrgrouprelation:delete")
    public Result delete(@RequestBody Long[] ids) {
        attrAttrgroupRelationService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
