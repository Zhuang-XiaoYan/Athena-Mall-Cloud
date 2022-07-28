package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.SkuFullReductionEntity;
import com.zhuangxiaoyan.athena.coupon.service.SkuFullReductionService;
import com.zhuangxiaoyan.common.to.SkuReductionTo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 商品满减信息
 * @date: 2022/7/28 15:57
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/skufullreduction")
public class SkuFullReductionController {

    @Autowired
    private SkuFullReductionService skuFullReductionService;

    /**
     * @description 保存skuinfo数据
     * @param: skuReductionTo
     * @date: 2022/7/28 15:57
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/saveinfo")
    public Result saveInfo(@RequestBody SkuReductionTo skuReductionTo) {
        skuFullReductionService.saveSkuReduction(skuReductionTo);
        return Result.ok();
    }

    /**
     * @description 查询所有数据
     * @param: params
     * @date: 2022/7/28 15:58
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:skufullreduction:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = skuFullReductionService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id进行查询的数据
     * @param: id
     * @date: 2022/7/28 15:58
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:skufullreduction:info")
    public Result info(@PathVariable("id") Long id) {
        SkuFullReductionEntity skuFullReduction = skuFullReductionService.getById(id);
        return Result.ok().put("skuFullReduction", skuFullReduction);
    }

    /**
     * @description 保存数据信息
     * @param: skuFullReduction
     * @date: 2022/7/28 15:58
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:skufullreduction:save")
    public Result save(@RequestBody SkuFullReductionEntity skuFullReduction) {
        skuFullReductionService.save(skuFullReduction);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: skuFullReduction
     * @date: 2022/7/28 15:58
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:skufullreduction:update")
    public Result update(@RequestBody SkuFullReductionEntity skuFullReduction) {
        skuFullReductionService.updateById(skuFullReduction);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 15:59
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:skufullreduction:delete")
    public Result delete(@RequestBody Long[] ids) {
        skuFullReductionService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
