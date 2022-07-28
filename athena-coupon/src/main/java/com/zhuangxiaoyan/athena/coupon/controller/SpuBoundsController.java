package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.SpuBoundsEntity;
import com.zhuangxiaoyan.athena.coupon.service.SpuBoundsService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 商品spu积分设置
 * @param: null
 * @date: 2022/7/28 16:01
 * @return:
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/spubounds")
public class SpuBoundsController {

    @Autowired
    private SpuBoundsService spuBoundsService;

    /**
     * @description 查询的所有数据
     * @param: params
     * @date: 2022/7/28 16:01
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:spubounds:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = spuBoundsService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/28 16:01
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:spubounds:info")
    public Result info(@PathVariable("id") Long id) {
        SpuBoundsEntity spuBounds = spuBoundsService.getById(id);
        return Result.ok().put("spuBounds", spuBounds);
    }

    /**
     * @description 保存数据
     * @param: spuBounds
     * @date: 2022/7/28 16:01
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @PostMapping("/save")
    //@RequiresPermissions("coupon:spubounds:save")
    public Result save(@RequestBody SpuBoundsEntity spuBounds) {
        spuBoundsService.save(spuBounds);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: spuBounds
     * @date: 2022/7/28 16:02
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:spubounds:update")
    public Result update(@RequestBody SpuBoundsEntity spuBounds) {
        spuBoundsService.updateById(spuBounds);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 16:02
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:spubounds:delete")
    public Result delete(@RequestBody Long[] ids) {
        spuBoundsService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
