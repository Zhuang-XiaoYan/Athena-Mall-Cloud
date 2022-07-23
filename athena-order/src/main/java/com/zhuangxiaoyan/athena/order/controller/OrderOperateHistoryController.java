package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.OrderOperateHistoryEntity;
import com.zhuangxiaoyan.athena.order.service.OrderOperateHistoryService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 订单操作历史记录
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@RestController
@RequestMapping("order/orderoperatehistory")
public class OrderOperateHistoryController {
    @Autowired
    private OrderOperateHistoryService orderOperateHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderoperatehistory:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderOperateHistoryService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderoperatehistory:info")
    public Result info(@PathVariable("id") Long id) {
        OrderOperateHistoryEntity orderOperateHistory = orderOperateHistoryService.getById(id);

        return Result.ok().put("orderOperateHistory", orderOperateHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderoperatehistory:save")
    public Result save(@RequestBody OrderOperateHistoryEntity orderOperateHistory) {
        orderOperateHistoryService.save(orderOperateHistory);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:orderoperatehistory:update")
    public Result update(@RequestBody OrderOperateHistoryEntity orderOperateHistory) {
        orderOperateHistoryService.updateById(orderOperateHistory);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderoperatehistory:delete")
    public Result delete(@RequestBody Long[] ids) {
        orderOperateHistoryService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
