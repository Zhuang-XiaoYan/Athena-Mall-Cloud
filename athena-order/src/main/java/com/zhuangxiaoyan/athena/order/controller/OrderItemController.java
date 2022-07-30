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
 * @description 订单项信息
 * @date: 2022/7/30 22:49
 * @author: xjl
 */

@RestController
@RequestMapping("order/orderitem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    /**
     * @description 查询所有数据
     * @param: params
     * @date: 2022/7/30 22:49
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderitem:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderItemService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 查询的id
     * @param: id
     * @date: 2022/7/30 22:50
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderitem:info")
    public Result info(@PathVariable("id") Long id) {
        OrderItemEntity orderItem = orderItemService.getById(id);
        return Result.ok().put("orderItem", orderItem);
    }

    /**
     * @description 保存数据
     * @param: orderItem
     * @date: 2022/7/30 22:51
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderitem:save")
    public Result save(@RequestBody OrderItemEntity orderItem) {
        orderItemService.save(orderItem);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: orderItem
     * @date: 2022/7/30 22:52
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:orderitem:update")
    public Result update(@RequestBody OrderItemEntity orderItem) {
        orderItemService.updateById(orderItem);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/30 22:53
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderitem:delete")
    public Result delete(@RequestBody Long[] ids) {
        orderItemService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
