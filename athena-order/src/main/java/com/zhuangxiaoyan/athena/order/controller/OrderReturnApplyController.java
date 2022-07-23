package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.OrderReturnApplyEntity;
import com.zhuangxiaoyan.athena.order.service.OrderReturnApplyService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 订单退货申请
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@RestController
@RequestMapping("order/orderreturnapply")
public class OrderReturnApplyController {
    @Autowired
    private OrderReturnApplyService orderReturnApplyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderreturnapply:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderReturnApplyService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderreturnapply:info")
    public Result info(@PathVariable("id") Long id) {
        OrderReturnApplyEntity orderReturnApply = orderReturnApplyService.getById(id);

        return Result.ok().put("orderReturnApply", orderReturnApply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderreturnapply:save")
    public Result save(@RequestBody OrderReturnApplyEntity orderReturnApply) {
        orderReturnApplyService.save(orderReturnApply);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:orderreturnapply:update")
    public Result update(@RequestBody OrderReturnApplyEntity orderReturnApply) {
        orderReturnApplyService.updateById(orderReturnApply);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderreturnapply:delete")
    public Result delete(@RequestBody Long[] ids) {
        orderReturnApplyService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
