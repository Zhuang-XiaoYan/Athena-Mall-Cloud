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
 * @description 秒杀活动商品关联
 * @date: 2022/7/28 15:55
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/seckillskurelation")
public class SeckillSkuRelationController {

    @Autowired
    private SeckillSkuRelationService seckillSkuRelationService;

    /**
     * @description 查询所有数据
     * @param: params
     * @date: 2022/7/28 15:56
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:seckillskurelation:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = seckillSkuRelationService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id进行查询
     * @param: id
     * @date: 2022/7/28 15:56
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:seckillskurelation:info")
    public Result info(@PathVariable("id") Long id) {
        SeckillSkuRelationEntity seckillSkuRelation = seckillSkuRelationService.getById(id);
        return Result.ok().put("seckillSkuRelation", seckillSkuRelation);
    }

    /**
     * @description 保存数据
     * @param: seckillSkuRelation
     * @date: 2022/7/28 15:56
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:seckillskurelation:save")
    public Result save(@RequestBody SeckillSkuRelationEntity seckillSkuRelation) {
        seckillSkuRelationService.save(seckillSkuRelation);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: seckillSkuRelation
     * @date: 2022/7/28 15:56
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:seckillskurelation:update")
    public Result update(@RequestBody SeckillSkuRelationEntity seckillSkuRelation) {
        seckillSkuRelationService.updateById(seckillSkuRelation);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 15:57
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:seckillskurelation:delete")
    public Result delete(@RequestBody Long[] ids) {
        seckillSkuRelationService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
