package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.SkuLadderEntity;
import com.zhuangxiaoyan.athena.coupon.service.SkuLadderService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 商品阶梯价格
 * @date: 2022/7/28 15:59
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/skuladder")
public class SkuLadderController {

    @Autowired
    private SkuLadderService skuLadderService;

    /**
     * @description 查询所有数据
     * @param: params
     * @date: 2022/7/28 15:59
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:skuladder:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = skuLadderService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id进行查询
     * @param: id
     * @date: 2022/7/28 15:59
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:skuladder:info")
    public Result info(@PathVariable("id") Long id) {
        SkuLadderEntity skuLadder = skuLadderService.getById(id);
        return Result.ok().put("skuLadder", skuLadder);
    }

    /**
     * @description 保存数据
     * @param: skuLadder
     * @date: 2022/7/28 16:00
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:skuladder:save")
    public Result save(@RequestBody SkuLadderEntity skuLadder) {
        skuLadderService.save(skuLadder);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: skuLadder
     * @date: 2022/7/28 16:00
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:skuladder:update")
    public Result update(@RequestBody SkuLadderEntity skuLadder) {
        skuLadderService.updateById(skuLadder);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 16:00
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:skuladder:delete")
    public Result delete(@RequestBody Long[] ids) {
        skuLadderService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
