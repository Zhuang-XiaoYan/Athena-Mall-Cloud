package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.SpuCommentEntity;
import com.zhuangxiaoyan.athena.product.service.SpuCommentService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description 商品的评价功能
 * @date: 2022/7/28 12:30
 * @return:
 * @author: xjl
 */
@RestController
@RequestMapping("product/spucomment")
public class SpuCommentController {
    @Autowired
    private SpuCommentService spuCommentService;

    /**
     * @description 查询所有的数据
     * @param: params
     * @date: 2022/7/28 12:36
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spucomment:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = spuCommentService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询的数据
     * @param: id
     * @date: 2022/7/28 12:36
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:spucomment:info")
    public Result info(@PathVariable("id") Long id) {
        SpuCommentEntity spuComment = spuCommentService.getById(id);
        return Result.ok().put("spuComment", spuComment);
    }

    /**
     * @description 保存数据
     * @param: spuComment
     * @date: 2022/7/28 12:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spucomment:save")
    public Result save(@RequestBody SpuCommentEntity spuComment) {
        spuCommentService.save(spuComment);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: spuComment
     * @date: 2022/7/28 12:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:spucomment:update")
    public Result update(@RequestBody SpuCommentEntity spuComment) {
        spuCommentService.updateById(spuComment);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 12:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spucomment:delete")
    public Result delete(@RequestBody Long[] ids) {
        spuCommentService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
