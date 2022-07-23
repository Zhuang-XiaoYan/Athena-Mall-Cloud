package com.zhuangxiaoyan.athena.coupon.controller;

import com.zhuangxiaoyan.athena.coupon.entity.MemberPriceEntity;
import com.zhuangxiaoyan.athena.coupon.service.MemberPriceService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 商品会员价格
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-10 11:14:46
 */
@RestController
@RequestMapping("coupon/memberprice")
public class MemberPriceController {
    @Autowired
    private MemberPriceService memberPriceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:memberprice:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberPriceService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:memberprice:info")
    public Result info(@PathVariable("id") Long id) {
        MemberPriceEntity memberPrice = memberPriceService.getById(id);

        return Result.ok().put("memberPrice", memberPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:memberprice:save")
    public Result save(@RequestBody MemberPriceEntity memberPrice) {
        memberPriceService.save(memberPrice);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:memberprice:update")
    public Result update(@RequestBody MemberPriceEntity memberPrice) {
        memberPriceService.updateById(memberPrice);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:memberprice:delete")
    public Result delete(@RequestBody Long[] ids) {
        memberPriceService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
