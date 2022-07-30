package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.OrderSettingEntity;
import com.zhuangxiaoyan.athena.order.service.OrderSettingService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 订单配置信息
 * @date: 2022/7/30 23:01
 * @author: xjl
 */

@RestController
@RequestMapping("order/ordersetting")
public class OrderSettingController {

    @Autowired
    private OrderSettingService orderSettingService;

    /**
     * @description 查询所有数据
     * @param: params
     * @date: 2022/7/30 23:02
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:ordersetting:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderSettingService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id
     * @param: id
     * @date: 2022/7/30 23:02
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:ordersetting:info")
    public Result info(@PathVariable("id") Long id) {
        OrderSettingEntity orderSetting = orderSettingService.getById(id);
        return Result.ok().put("orderSetting", orderSetting);
    }

    /**
     * @description 保存数据
     * @param: orderSetting
     * @date: 2022/7/30 23:03
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:ordersetting:save")
    public Result save(@RequestBody OrderSettingEntity orderSetting) {
        orderSettingService.save(orderSetting);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: orderSetting
     * @date: 2022/7/30 23:03
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:ordersetting:update")
    public Result update(@RequestBody OrderSettingEntity orderSetting) {
        orderSettingService.updateById(orderSetting);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/30 23:04
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:ordersetting:delete")
    public Result delete(@RequestBody Long[] ids) {
        orderSettingService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
