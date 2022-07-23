package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.SkuSaleAttrValueEntity;
import com.zhuangxiaoyan.athena.product.service.SkuSaleAttrValueService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
@RestController
@RequestMapping("product/skusaleattrvalue")
public class SkuSaleAttrValueController {
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:skusaleattrvalue:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = skuSaleAttrValueService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:skusaleattrvalue:info")
    public Result info(@PathVariable("id") Long id) {
        SkuSaleAttrValueEntity skuSaleAttrValue = skuSaleAttrValueService.getById(id);

        return Result.ok().put("skuSaleAttrValue", skuSaleAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:skusaleattrvalue:save")
    public Result save(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValue) {
        skuSaleAttrValueService.save(skuSaleAttrValue);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:skusaleattrvalue:update")
    public Result update(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValue) {
        skuSaleAttrValueService.updateById(skuSaleAttrValue);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:skusaleattrvalue:delete")
    public Result delete(@RequestBody Long[] ids) {
        skuSaleAttrValueService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
