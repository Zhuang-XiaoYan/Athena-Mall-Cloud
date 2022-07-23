package com.zhuangxiaoyan.athena.order.controller;

import com.zhuangxiaoyan.athena.order.entity.MqMessageEntity;
import com.zhuangxiaoyan.athena.order.service.MqMessageService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 22:23:49
 */
@RestController
@RequestMapping("order/mqmessage")
public class MqMessageController {
    @Autowired
    private MqMessageService mqMessageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:mqmessage:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = mqMessageService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{messageId}")
    //@RequiresPermissions("order:mqmessage:info")
    public Result info(@PathVariable("messageId") String messageId) {
        MqMessageEntity mqMessage = mqMessageService.getById(messageId);

        return Result.ok().put("mqMessage", mqMessage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:mqmessage:save")
    public Result save(@RequestBody MqMessageEntity mqMessage) {
        mqMessageService.save(mqMessage);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:mqmessage:update")
    public Result update(@RequestBody MqMessageEntity mqMessage) {
        mqMessageService.updateById(mqMessage);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:mqmessage:delete")
    public Result delete(@RequestBody String[] messageIds) {
        mqMessageService.removeByIds(Arrays.asList(messageIds));

        return Result.ok();
    }

}
