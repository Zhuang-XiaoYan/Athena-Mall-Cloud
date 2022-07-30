package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.PaymentInfoEntity;
import com.zhuangxiaoyan.athena.order.service.PaymentInfoService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 支付信息表
 * @date: 2022/7/30 23:04
 * @author: xjl
 */

@RestController
@RequestMapping("order/paymentinfo")
public class PaymentInfoController {

    @Autowired
    private PaymentInfoService paymentInfoService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/30 23:04
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:paymentinfo:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = paymentInfoService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/30 23:05
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:paymentinfo:info")
    public Result info(@PathVariable("id") Long id) {
        PaymentInfoEntity paymentInfo = paymentInfoService.getById(id);
        return Result.ok().put("paymentInfo", paymentInfo);
    }

    /**
     * @description 保存数据
     * @param: paymentInfo
     * @date: 2022/7/30 23:05
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:paymentinfo:save")
    public Result save(@RequestBody PaymentInfoEntity paymentInfo) {
        paymentInfoService.save(paymentInfo);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: paymentInfo
     * @date: 2022/7/30 23:06
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:paymentinfo:update")
    public Result update(@RequestBody PaymentInfoEntity paymentInfo) {
        paymentInfoService.updateById(paymentInfo);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/30 23:06
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:paymentinfo:delete")
    public Result delete(@RequestBody Long[] ids) {
        paymentInfoService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
