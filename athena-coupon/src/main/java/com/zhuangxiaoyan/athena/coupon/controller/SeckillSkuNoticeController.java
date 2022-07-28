package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.SeckillSkuNoticeEntity;
import com.zhuangxiaoyan.athena.coupon.service.SeckillSkuNoticeService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 秒杀商品通知订阅
 * @date: 2022/7/28 15:53
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/seckillskunotice")
public class SeckillSkuNoticeController {

    @Autowired
    private SeckillSkuNoticeService seckillSkuNoticeService;

    /**
     * @description 查询所有数据
     * @param: params
     * @date: 2022/7/28 15:54
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:seckillskunotice:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = seckillSkuNoticeService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/28 15:54
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:seckillskunotice:info")
    public Result info(@PathVariable("id") Long id) {
        SeckillSkuNoticeEntity seckillSkuNotice = seckillSkuNoticeService.getById(id);

        return Result.ok().put("seckillSkuNotice", seckillSkuNotice);
    }

    /**
     * @description 保存数据
     * @param: seckillSkuNotice
     * @date: 2022/7/28 15:54
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:seckillskunotice:save")
    public Result save(@RequestBody SeckillSkuNoticeEntity seckillSkuNotice) {
        seckillSkuNoticeService.save(seckillSkuNotice);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: seckillSkuNotice
     * @date: 2022/7/28 15:54
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:seckillskunotice:update")
    public Result update(@RequestBody SeckillSkuNoticeEntity seckillSkuNotice) {
        seckillSkuNoticeService.updateById(seckillSkuNotice);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 15:55
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:seckillskunotice:delete")
    public Result delete(@RequestBody Long[] ids) {
        seckillSkuNoticeService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
