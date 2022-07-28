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
 * @description 商品会员价格
 * @date: 2022/7/28 15:38
 * @author: xjl
 */

@RestController
@RequestMapping("coupon/memberprice")
public class MemberPriceController {

    @Autowired
    private MemberPriceService memberPriceService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/28 15:38
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:memberprice:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberPriceService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/28 15:38
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:memberprice:info")
    public Result info(@PathVariable("id") Long id) {
        MemberPriceEntity memberPrice = memberPriceService.getById(id);
        return Result.ok().put("memberPrice", memberPrice);
    }

    /**
     * @description 保存数据
     * @param: memberPrice
     * @date: 2022/7/28 15:38
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:memberprice:save")
    public Result save(@RequestBody MemberPriceEntity memberPrice) {
        memberPriceService.save(memberPrice);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: memberPrice
     * @date: 2022/7/28 15:39
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:memberprice:update")
    public Result update(@RequestBody MemberPriceEntity memberPrice) {
        memberPriceService.updateById(memberPrice);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 15:39
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:memberprice:delete")
    public Result delete(@RequestBody Long[] ids) {
        memberPriceService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
