package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.OrderEntity;
import com.zhuangxiaoyan.athena.order.service.OrderService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 订单
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@RestController
@RequestMapping("order/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:order:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:order:info")
    public Result info(@PathVariable("id") Long id) {
        OrderEntity order = orderService.getById(id);

        return Result.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:order:save")
    public Result save(@RequestBody OrderEntity order) {
        orderService.save(order);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:order:update")
    public Result update(@RequestBody OrderEntity order) {
        orderService.updateById(order);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:order:delete")
    public Result delete(@RequestBody Long[] ids) {
        orderService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
