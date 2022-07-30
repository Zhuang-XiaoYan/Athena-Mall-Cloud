package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.entity.MemberReceiveAddressEntity;
import com.zhuangxiaoyan.athena.member.service.MemberReceiveAddressService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 会员收货地址
 * @date: 2022/7/30 17:41
 * @author: xjl
*/

@RestController
@RequestMapping("member/memberreceiveaddress")
public class MemberReceiveAddressController {

    @Autowired
    private MemberReceiveAddressService memberReceiveAddressService;

    /**
     * @description 查询所有的列表
      * @param: params
     * @date: 2022/7/30 22:01
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberreceiveaddress:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberReceiveAddressService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询
      * @param: id
     * @date: 2022/7/30 22:01
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberreceiveaddress:info")
    public Result info(@PathVariable("id") Long id) {
        MemberReceiveAddressEntity memberReceiveAddress = memberReceiveAddressService.getById(id);
        return Result.ok().put("memberReceiveAddress", memberReceiveAddress);
    }

    /**
     * @description 保存数据
      * @param: memberReceiveAddress
     * @date: 2022/7/30 22:02
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberreceiveaddress:save")
    public Result save(@RequestBody MemberReceiveAddressEntity memberReceiveAddress) {
        memberReceiveAddressService.save(memberReceiveAddress);
        return Result.ok();
    }

    /**
     * @description 更新数据
      * @param: memberReceiveAddress
     * @date: 2022/7/30 22:03
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @RequestMapping("/update")
    //@RequiresPermissions("member:memberreceiveaddress:update")
    public Result update(@RequestBody MemberReceiveAddressEntity memberReceiveAddress) {
        memberReceiveAddressService.updateById(memberReceiveAddress);
        return Result.ok();
    }

    /**
     * @description 删除数据
      * @param: ids
     * @date: 2022/7/30 22:03
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberreceiveaddress:delete")
    public Result delete(@RequestBody Long[] ids) {
        memberReceiveAddressService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
