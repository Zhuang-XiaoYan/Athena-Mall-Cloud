package com.zhuangxiaoyan.athena.ware.controller;

import com.zhuangxiaoyan.athena.ware.entity.WareOrderTaskEntity;
import com.zhuangxiaoyan.athena.ware.service.WareOrderTaskService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 库存工作单
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:38:27
 */
@RestController
@RequestMapping("ware/wareordertask")
public class WareOrderTaskController {
    @Autowired
    private WareOrderTaskService wareOrderTaskService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:wareordertask:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = wareOrderTaskService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:wareordertask:info")
    public Result info(@PathVariable("id") Long id) {
        WareOrderTaskEntity wareOrderTask = wareOrderTaskService.getById(id);

        return Result.ok().put("wareOrderTask", wareOrderTask);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:wareordertask:save")
    public Result save(@RequestBody WareOrderTaskEntity wareOrderTask) {
        wareOrderTaskService.save(wareOrderTask);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:wareordertask:update")
    public Result update(@RequestBody WareOrderTaskEntity wareOrderTask) {
        wareOrderTaskService.updateById(wareOrderTask);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:wareordertask:delete")
    public Result delete(@RequestBody Long[] ids) {
        wareOrderTaskService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
