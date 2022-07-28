package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.SpuInfoDescEntity;
import com.zhuangxiaoyan.athena.product.service.SpuInfoDescService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description spu信息介绍
 * @param: null
 * @date: 2022/7/28 12:49
 * @return:
 * @author: xjl
 */

@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {

    @Autowired
    private SpuInfoDescService spuInfoDescService;

    /**
     * @description 查询所有的信息数据
     * @param: params
     * @date: 2022/7/28 12:49
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuinfodesc:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = spuInfoDescService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: spuId
     * @date: 2022/7/28 12:49
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{spuId}")
    //@RequiresPermissions("product:spuinfodesc:info")
    public Result info(@PathVariable("spuId") Long spuId) {
        SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);
        return Result.ok().put("spuInfoDesc", spuInfoDesc);
    }

    /**
     * @description 保存数据
     * @param: spuInfoDesc
     * @date: 2022/7/28 12:51
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spuinfodesc:save")
    public Result save(@RequestBody SpuInfoDescEntity spuInfoDesc) {
        spuInfoDescService.save(spuInfoDesc);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: spuInfoDesc
     * @date: 2022/7/28 12:51
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:spuinfodesc:update")
    public Result update(@RequestBody SpuInfoDescEntity spuInfoDesc) {
        spuInfoDescService.updateById(spuInfoDesc);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: spuIds
     * @date: 2022/7/28 12:51
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spuinfodesc:delete")
    public Result delete(@RequestBody Long[] spuIds) {
        spuInfoDescService.removeByIds(Arrays.asList(spuIds));
        return Result.ok();
    }

}
