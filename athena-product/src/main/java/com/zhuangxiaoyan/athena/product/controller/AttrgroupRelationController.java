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
 * @description 属性&属性分组关联
 * @date: 2022/7/28 11:00
 * @return:
 * @author: xjl
 */

@RestController
@RequestMapping("product/attrgrouprelation")
public class AttrgroupRelationController {

    @Autowired
    private AttrgroupRelationService attrrgroupRelationService;

    /**
     * @description 简单列表信息查询
     * @param: params
     * @date: 2022/7/28 11:00
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attrattrgrouprelation:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrrgroupRelationService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 查询基础信息
     * @param: id
     * @date: 2022/7/28 11:00
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:attrattrgrouprelation:info")
    public Result info(@PathVariable("id") Long id) {
        AttrgroupRelationEntity attrAttrgroupRelation = attrrgroupRelationService.getById(id);

        return Result.ok().put("attrAttrgroupRelation", attrAttrgroupRelation);
    }

    /**
     * @description 简单保存信息
     * @param: attrAttrgroupRelation
     * @date: 2022/7/28 11:01
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrattrgrouprelation:save")
    public Result save(@RequestBody AttrgroupRelationEntity attrAttrgroupRelation) {
        attrrgroupRelationService.save(attrAttrgroupRelation);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: attrAttrgroupRelation
     * @date: 2022/7/28 12:12
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrattrgrouprelation:update")
    public Result update(@RequestBody AttrgroupRelationEntity attrAttrgroupRelation) {
        attrrgroupRelationService.updateById(attrAttrgroupRelation);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 12:13
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrattrgrouprelation:delete")
    public Result delete(@RequestBody Long[] ids) {
        attrrgroupRelationService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
