package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.SeckillPromotionEntity;
import com.zhuangxiaoyan.athena.coupon.service.SeckillPromotionService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 秒杀活动
 * @date: 2022/7/28 15:39
 * @author: xjl
 */
@RestController
@RequestMapping("coupon/seckillpromotion")
public class SeckillPromotionController {

    @Autowired
    private SeckillPromotionService seckillPromotionService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/28 15:39
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:seckillpromotion:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = seckillPromotionService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/28 15:40
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:seckillpromotion:info")
    public Result info(@PathVariable("id") Long id) {
        SeckillPromotionEntity seckillPromotion = seckillPromotionService.getById(id);
        return Result.ok().put("seckillPromotion", seckillPromotion);
    }

    /**
     * @description 保存数据
     * @param: seckillPromotion
     * @date: 2022/7/28 15:40
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:seckillpromotion:save")
    public Result save(@RequestBody SeckillPromotionEntity seckillPromotion) {
        seckillPromotionService.save(seckillPromotion);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: seckillPromotion
     * @date: 2022/7/28 15:40
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:seckillpromotion:update")
    public Result update(@RequestBody SeckillPromotionEntity seckillPromotion) {
        seckillPromotionService.updateById(seckillPromotion);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 15:40
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:seckillpromotion:delete")
    public Result delete(@RequestBody Long[] ids) {
        seckillPromotionService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
