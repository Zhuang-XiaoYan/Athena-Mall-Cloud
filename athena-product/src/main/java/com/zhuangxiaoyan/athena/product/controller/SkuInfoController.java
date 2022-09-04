package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.SkuInfoEntity;
import com.zhuangxiaoyan.athena.product.service.SkuInfoService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

/**
 * @description sku信息
 * @date: 2022/7/28 12:25
 * @return:
 * @author: xjl
 */

@RestController
@RequestMapping("product/skuinfo")
public class SkuInfoController {

    @Autowired
    private SkuInfoService skuInfoService;

    /**
     * 根据skuId查询当前商品的价格
     * @param skuId
     * @return
     */
    @GetMapping(value = "/{skuId}/price")
    public BigDecimal getPrice(@PathVariable("skuId") Long skuId) {
        //获取当前商品的信息
        SkuInfoEntity skuInfo = skuInfoService.getById(skuId);
        //获取商品的价格
        BigDecimal price = skuInfo.getPrice();
        return price;
    }

    /**
     * @description 查询所有的sku的信息
     * @param: params
     * @date: 2022/7/28 12:26
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:skuinfo:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = skuInfoService.queryPageByCondition(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过skuid查询信息数据
     * @param: skuId
     * @date: 2022/7/28 12:26
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{skuId}")
    //@RequiresPermissions("product:skuinfo:info")
    public Result info(@PathVariable("skuId") Long skuId) {
        SkuInfoEntity skuInfo = skuInfoService.getById(skuId);

        return Result.ok().put("skuInfo", skuInfo);
    }

    /**
     * @description 保存数据
     * @param: skuInfo
     * @date: 2022/7/28 12:27
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:skuinfo:save")
    public Result save(@RequestBody SkuInfoEntity skuInfo) {
        skuInfoService.save(skuInfo);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: skuInfo
     * @date: 2022/7/28 12:27
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:skuinfo:update")
    public Result update(@RequestBody SkuInfoEntity skuInfo) {
        skuInfoService.updateById(skuInfo);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: skuIds
     * @date: 2022/7/28 12:27
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:skuinfo:delete")
    public Result delete(@RequestBody Long[] skuIds) {
        skuInfoService.removeByIds(Arrays.asList(skuIds));
        return Result.ok();
    }

}
