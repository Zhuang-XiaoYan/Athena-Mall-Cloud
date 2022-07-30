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
 * @description 退款信息
 * @date: 2022/7/30 23:07
 * @author: xjl
 */

@RestController
@RequestMapping("order/refundinfo")
public class RefundInfoController {

    @Autowired
    private RefundInfoService refundInfoService;

    /**
     * @description 查询所有数据
     * @param: params
     * @date: 2022/7/30 23:08
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:refundinfo:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = refundInfoService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询
     * @param: id
     * @date: 2022/7/30 23:24
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:refundinfo:info")
    public Result info(@PathVariable("id") Long id) {
        RefundInfoEntity refundInfo = refundInfoService.getById(id);
        return Result.ok().put("refundInfo", refundInfo);
    }

    /**
     * @description 保存数据
     * @param: refundInfo
     * @date: 2022/7/30 23:25
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:refundinfo:save")
    public Result save(@RequestBody RefundInfoEntity refundInfo) {
        refundInfoService.save(refundInfo);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: refundInfo
     * @date: 2022/7/30 23:25
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:refundinfo:update")
    public Result update(@RequestBody RefundInfoEntity refundInfo) {
        refundInfoService.updateById(refundInfo);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/30 23:26
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:refundinfo:delete")
    public Result delete(@RequestBody Long[] ids) {
        refundInfoService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
