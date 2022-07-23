package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.OrderItemEntity;
import com.zhuangxiaoyan.athena.order.service.OrderItemService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 订单项信息
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@RestController
@RequestMapping("order/orderitem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderitem:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderItemService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderitem:info")
    public Result info(@PathVariable("id") Long id) {
        OrderItemEntity orderItem = orderItemService.getById(id);

        return Result.ok().put("orderItem", orderItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderitem:save")
    public Result save(@RequestBody OrderItemEntity orderItem) {
        orderItemService.save(orderItem);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:orderitem:update")
    public Result update(@RequestBody OrderItemEntity orderItem) {
        orderItemService.updateById(orderItem);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderitem:delete")
    public Result delete(@RequestBody Long[] ids) {
        orderItemService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
