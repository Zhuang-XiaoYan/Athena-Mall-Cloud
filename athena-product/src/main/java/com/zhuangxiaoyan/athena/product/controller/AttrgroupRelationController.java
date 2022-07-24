package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.AttrgroupRelationEntity;
import com.zhuangxiaoyan.athena.product.service.AttrgroupRelationService;
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
@RequestMapping("product/attrgrouprelation")
public class AttrgroupRelationController {

    @Autowired
    private AttrgroupRelationService attrrgroupRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attrattrgrouprelation:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrrgroupRelationService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:attrattrgrouprelation:info")
    public Result info(@PathVariable("id") Long id) {
        AttrgroupRelationEntity attrAttrgroupRelation = attrrgroupRelationService.getById(id);

        return Result.ok().put("attrAttrgroupRelation", attrAttrgroupRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrattrgrouprelation:save")
    public Result save(@RequestBody AttrgroupRelationEntity attrAttrgroupRelation) {
        attrrgroupRelationService.save(attrAttrgroupRelation);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrattrgrouprelation:update")
    public Result update(@RequestBody AttrgroupRelationEntity attrAttrgroupRelation) {
        attrrgroupRelationService.updateById(attrAttrgroupRelation);
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrattrgrouprelation:delete")
    public Result delete(@RequestBody Long[] ids) {
        attrrgroupRelationService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
