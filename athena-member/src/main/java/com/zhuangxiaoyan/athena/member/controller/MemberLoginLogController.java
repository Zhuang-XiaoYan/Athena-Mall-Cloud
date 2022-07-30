package com.zhuangxiaoyan.athena.member.controller;

import com.zhuangxiaoyan.athena.member.entity.MemberLoginLogEntity;
import com.zhuangxiaoyan.athena.member.service.MemberLoginLogService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 会员登录记录
 * @date: 2022/7/30 17:41
 * @author: xjl
 */

@RestController
@RequestMapping("member/memberloginlog")
public class MemberLoginLogController {

    @Autowired
    private MemberLoginLogService memberLoginLogService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/30 21:56
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberloginlog:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberLoginLogService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/30 21:57
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberloginlog:info")
    public Result info(@PathVariable("id") Long id) {
        MemberLoginLogEntity memberLoginLog = memberLoginLogService.getById(id);
        return Result.ok().put("memberLoginLog", memberLoginLog);
    }

    /**
     * @description 数据保存
     * @param: memberLoginLog
     * @date: 2022/7/30 21:57
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberloginlog:save")
    public Result save(@RequestBody MemberLoginLogEntity memberLoginLog) {
        memberLoginLogService.save(memberLoginLog);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: memberLoginLog
     * @date: 2022/7/30 21:57
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:memberloginlog:update")
    public Result update(@RequestBody MemberLoginLogEntity memberLoginLog) {
        memberLoginLogService.updateById(memberLoginLog);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/30 21:57
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberloginlog:delete")
    public Result delete(@RequestBody Long[] ids) {
        memberLoginLogService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
