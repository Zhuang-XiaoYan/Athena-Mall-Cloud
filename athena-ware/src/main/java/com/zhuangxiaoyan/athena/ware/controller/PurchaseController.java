package com.zhuangxiaoyan.athena.ware.controller;

import com.zhuangxiaoyan.athena.ware.entity.PurchaseEntity;
import com.zhuangxiaoyan.athena.ware.service.PurchaseService;
import com.zhuangxiaoyan.athena.ware.vo.MergeVo;
import com.zhuangxiaoyan.athena.ware.vo.PurchaseDoneVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description 采购信息
 * @date: 2022/7/30 23:51
 * @author: xjl
 */

@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/done")
    public Result finish(@RequestBody PurchaseDoneVo purchaseDoneVo) {
        purchaseService.done(purchaseDoneVo);
        return Result.ok();
    }

    @PostMapping("/received")
    public Result received(@RequestBody List<Long> ids) {
        purchaseService.received(ids);
        return Result.ok();
    }

    @PostMapping("/merge")
    public Result merge(@RequestBody MergeVo mergeVo) {
        purchaseService.merge(mergeVo);
        return Result.ok();
    }

    @GetMapping("/unrecaive/list")
    public Result unrecaivelist(@RequestParam Map<String, Object> params) {
        PageUtils page = purchaseService.queryPageUnrecaive(params);
        return Result.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:purchase:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = purchaseService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:purchase:info")
    public Result info(@PathVariable("id") Long id) {
        PurchaseEntity purchase = purchaseService.getById(id);
        return Result.ok().put("purchase", purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:purchase:save")
    public Result save(@RequestBody PurchaseEntity purchase) {
        purchase.setUpdateTime(new Date());
        purchase.setCreateTime(new Date());
        purchaseService.save(purchase);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:purchase:update")
    public Result update(@RequestBody PurchaseEntity purchase) {
        purchaseService.updateById(purchase);
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:purchase:delete")
    public Result delete(@RequestBody Long[] ids) {
        purchaseService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
