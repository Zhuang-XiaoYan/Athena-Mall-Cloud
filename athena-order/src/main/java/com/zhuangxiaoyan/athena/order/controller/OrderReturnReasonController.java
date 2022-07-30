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
 * @description 退货原因
 * @date: 2022/7/30 22:57
 * @author: xjl
 */

@RestController
@RequestMapping("order/orderreturnreason")
public class OrderReturnReasonController {

    @Autowired
    private OrderReturnReasonService orderReturnReasonService;

    /**
     * @description 查询所有数据
     * @param: params
     * @date: 2022/7/30 22:58
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderreturnreason:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderReturnReasonService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/30 22:58
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderreturnreason:info")
    public Result info(@PathVariable("id") Long id) {
        OrderReturnReasonEntity orderReturnReason = orderReturnReasonService.getById(id);
        return Result.ok().put("orderReturnReason", orderReturnReason);
    }

    /**
     * @description 通过保存
     * @param: orderReturnReason
     * @date: 2022/7/30 22:59
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderreturnreason:save")
    public Result save(@RequestBody OrderReturnReasonEntity orderReturnReason) {
        orderReturnReasonService.save(orderReturnReason);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: orderReturnReason
     * @date: 2022/7/30 23:00
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:orderreturnreason:update")
    public Result update(@RequestBody OrderReturnReasonEntity orderReturnReason) {
        orderReturnReasonService.updateById(orderReturnReason);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/30 23:01
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderreturnreason:delete")
    public Result delete(@RequestBody Long[] ids) {
        orderReturnReasonService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
