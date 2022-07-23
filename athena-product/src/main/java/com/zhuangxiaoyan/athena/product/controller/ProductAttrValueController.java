package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.ProductAttrValueEntity;
import com.zhuangxiaoyan.athena.product.service.ProductAttrValueService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * spu属性值
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
@RestController
@RequestMapping("product/productattrvalue")
public class ProductAttrValueController {
    @Autowired
    private ProductAttrValueService productAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:productattrvalue:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = productAttrValueService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:productattrvalue:info")
    public Result info(@PathVariable("id") Long id) {
        ProductAttrValueEntity productAttrValue = productAttrValueService.getById(id);

        return Result.ok().put("productAttrValue", productAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:productattrvalue:save")
    public Result save(@RequestBody ProductAttrValueEntity productAttrValue) {
        productAttrValueService.save(productAttrValue);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:productattrvalue:update")
    public Result update(@RequestBody ProductAttrValueEntity productAttrValue) {
        productAttrValueService.updateById(productAttrValue);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //RequiresPermissions("product:productattrvalue:delete")
    public Result delete(@RequestBody Long[] ids) {
        productAttrValueService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
