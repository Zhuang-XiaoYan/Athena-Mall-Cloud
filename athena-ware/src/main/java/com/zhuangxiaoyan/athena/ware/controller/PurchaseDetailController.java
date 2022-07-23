package com.zhuangxiaoyan.athena.ware.controller;

import com.zhuangxiaoyan.athena.ware.entity.PurchaseDetailEntity;
import com.zhuangxiaoyan.athena.ware.service.PurchaseDetailService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:38:27
 */
@RestController
@RequestMapping("ware/purchasedetail")
public class PurchaseDetailController {
    @Autowired
    private PurchaseDetailService purchaseDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:purchasedetail:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = purchaseDetailService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:purchasedetail:info")
    public Result info(@PathVariable("id") Long id) {
        PurchaseDetailEntity purchaseDetail = purchaseDetailService.getById(id);

        return Result.ok().put("purchaseDetail", purchaseDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:purchasedetail:save")
    public Result save(@RequestBody PurchaseDetailEntity purchaseDetail) {
        purchaseDetailService.save(purchaseDetail);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:purchasedetail:update")
    public Result update(@RequestBody PurchaseDetailEntity purchaseDetail) {
        purchaseDetailService.updateById(purchaseDetail);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:purchasedetail:delete")
    public Result delete(@RequestBody Long[] ids) {
        purchaseDetailService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
