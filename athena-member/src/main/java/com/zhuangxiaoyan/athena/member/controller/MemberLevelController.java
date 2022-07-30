package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.entity.MemberLevelEntity;
import com.zhuangxiaoyan.athena.member.service.MemberLevelService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 会员等级
 * @date: 2022/7/30 17:40
 * @author: xjl
 */

@RestController
@RequestMapping("member/memberlevel")
public class MemberLevelController {

    @Autowired
    private MemberLevelService memberLevelService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/30 21:55
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberlevel:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberLevelService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过的id查询数
     * @param: id
     * @date: 2022/7/30 21:55
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberlevel:info")
    public Result info(@PathVariable("id") Long id) {
        MemberLevelEntity memberLevel = memberLevelService.getById(id);
        return Result.ok().put("memberLevel", memberLevel);
    }

    /**
     * @description 保存数据
     * @param: memberLevel
     * @date: 2022/7/30 21:55
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberlevel:save")
    public Result save(@RequestBody MemberLevelEntity memberLevel) {
        memberLevelService.save(memberLevel);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: memberLevel
     * @date: 2022/7/30 21:56
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:memberlevel:update")
    public Result update(@RequestBody MemberLevelEntity memberLevel) {
        memberLevelService.updateById(memberLevel);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/30 21:56
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberlevel:delete")
    public Result delete(@RequestBody Long[] ids) {
        memberLevelService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
