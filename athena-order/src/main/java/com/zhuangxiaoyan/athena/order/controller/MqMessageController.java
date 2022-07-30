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
 * @description MqMessageController
 * @date: 2022/7/30 22:42
 * @author: xjl
 */

@RestController
@RequestMapping("order/mqmessage")
public class MqMessageController {

    @Autowired
    private MqMessageService mqMessageService;

    /**
     * @description 查询的所有数据
     * @param: params
     * @date: 2022/7/30 22:43
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:mqmessage:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = mqMessageService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询
     * @param: messageId
     * @date: 2022/7/30 22:44
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{messageId}")
    //@RequiresPermissions("order:mqmessage:info")
    public Result info(@PathVariable("messageId") String messageId) {
        MqMessageEntity mqMessage = mqMessageService.getById(messageId);
        return Result.ok().put("mqMessage", mqMessage);
    }

    /**
     * @description 保存数据
     * @param: mqMessage
     * @date: 2022/7/30 22:44
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:mqmessage:save")
    public Result save(@RequestBody MqMessageEntity mqMessage) {
        mqMessageService.save(mqMessage);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: mqMessage
     * @date: 2022/7/30 22:44
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:mqmessage:update")
    public Result update(@RequestBody MqMessageEntity mqMessage) {
        mqMessageService.updateById(mqMessage);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: messageIds
     * @date: 2022/7/30 22:45
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:mqmessage:delete")
    public Result delete(@RequestBody String[] messageIds) {
        mqMessageService.removeByIds(Arrays.asList(messageIds));
        return Result.ok();
    }

}
