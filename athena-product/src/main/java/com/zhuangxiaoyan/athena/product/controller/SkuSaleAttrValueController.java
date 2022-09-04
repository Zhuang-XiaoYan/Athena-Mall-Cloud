package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.SkuSaleAttrValueEntity;
import com.zhuangxiaoyan.athena.product.service.SkuSaleAttrValueService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @description sku销售属性值
 * @param: null
 * @date: 2022/7/28 12:28
 * @return:
 * @author: xjl
 */

@RestController
@RequestMapping("product/skusaleattrvalue")
public class SkuSaleAttrValueController {

    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @GetMapping("/stringlist/{skuId}")
    public List<String> getSkuSaleAttrValues(@PathVariable("skuId") Long skuId){
        List<String> result=skuSaleAttrValueService.getSkuSaleAttrValuesStringList(skuId);
        return result;
    }

    /**
     * @description 查询所有sku的销售属性值
     * @param: params
     * @date: 2022/7/28 12:28
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:skusaleattrvalue:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = skuSaleAttrValueService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过的id查询的单个数据
     * @param: id
     * @date: 2022/7/28 12:29
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:skusaleattrvalue:info")
    public Result info(@PathVariable("id") Long id) {
        SkuSaleAttrValueEntity skuSaleAttrValue = skuSaleAttrValueService.getById(id);
        return Result.ok().put("skuSaleAttrValue", skuSaleAttrValue);
    }

    /**
     * @description 保存数据
     * @param: skuSaleAttrValue
     * @date: 2022/7/28 12:30
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:skusaleattrvalue:save")
    public Result save(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValue) {
        skuSaleAttrValueService.save(skuSaleAttrValue);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: null
     * @date: 2022/7/28 12:29
     * @return:
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:skusaleattrvalue:update")
    public Result update(@RequestBody SkuSaleAttrValueEntity skuSaleAttrValue) {
        skuSaleAttrValueService.updateById(skuSaleAttrValue);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 12:29
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:skusaleattrvalue:delete")
    public Result delete(@RequestBody Long[] ids) {
        skuSaleAttrValueService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
