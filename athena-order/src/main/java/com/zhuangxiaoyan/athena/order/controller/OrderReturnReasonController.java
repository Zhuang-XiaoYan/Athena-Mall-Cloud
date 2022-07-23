package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.OrderReturnReasonEntity;
import com.zhuangxiaoyan.athena.order.service.OrderReturnReasonService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 退货原因
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@RestController
@RequestMapping("order/orderreturnreason")
public class OrderReturnReasonController {
    @Autowired
    private OrderReturnReasonService orderReturnReasonService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderreturnreason:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderReturnReasonService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderreturnreason:info")
    public Result info(@PathVariable("id") Long id) {
        OrderReturnReasonEntity orderReturnReason = orderReturnReasonService.getById(id);

        return Result.ok().put("orderReturnReason", orderReturnReason);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderreturnreason:save")
    public Result save(@RequestBody OrderReturnReasonEntity orderReturnReason) {
        orderReturnReasonService.save(orderReturnReason);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:orderreturnreason:update")
    public Result update(@RequestBody OrderReturnReasonEntity orderReturnReason) {
        orderReturnReasonService.updateById(orderReturnReason);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderreturnreason:delete")
    public Result delete(@RequestBody Long[] ids) {
        orderReturnReasonService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
