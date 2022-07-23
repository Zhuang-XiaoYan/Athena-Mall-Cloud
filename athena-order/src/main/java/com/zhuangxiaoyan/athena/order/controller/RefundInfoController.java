package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.RefundInfoEntity;
import com.zhuangxiaoyan.athena.order.service.RefundInfoService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 退款信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@RestController
@RequestMapping("order/refundinfo")
public class RefundInfoController {
    @Autowired
    private RefundInfoService refundInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:refundinfo:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = refundInfoService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:refundinfo:info")
    public Result info(@PathVariable("id") Long id) {
        RefundInfoEntity refundInfo = refundInfoService.getById(id);

        return Result.ok().put("refundInfo", refundInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:refundinfo:save")
    public Result save(@RequestBody RefundInfoEntity refundInfo) {
        refundInfoService.save(refundInfo);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:refundinfo:update")
    public Result update(@RequestBody RefundInfoEntity refundInfo) {
        refundInfoService.updateById(refundInfo);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:refundinfo:delete")
    public Result delete(@RequestBody Long[] ids) {
        refundInfoService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
