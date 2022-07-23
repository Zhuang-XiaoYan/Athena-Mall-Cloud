package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.SeckillSkuRelationEntity;
import com.zhuangxiaoyan.athena.coupon.service.SeckillSkuRelationService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 秒杀活动商品关联
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RestController
@RequestMapping("coupon/seckillskurelation")
public class SeckillSkuRelationController {
    @Autowired
    private SeckillSkuRelationService seckillSkuRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:seckillskurelation:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = seckillSkuRelationService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:seckillskurelation:info")
    public Result info(@PathVariable("id") Long id) {
        SeckillSkuRelationEntity seckillSkuRelation = seckillSkuRelationService.getById(id);

        return Result.ok().put("seckillSkuRelation", seckillSkuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:seckillskurelation:save")
    public Result save(@RequestBody SeckillSkuRelationEntity seckillSkuRelation) {
        seckillSkuRelationService.save(seckillSkuRelation);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:seckillskurelation:update")
    public Result update(@RequestBody SeckillSkuRelationEntity seckillSkuRelation) {
        seckillSkuRelationService.updateById(seckillSkuRelation);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:seckillskurelation:delete")
    public Result delete(@RequestBody Long[] ids) {
        seckillSkuRelationService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
