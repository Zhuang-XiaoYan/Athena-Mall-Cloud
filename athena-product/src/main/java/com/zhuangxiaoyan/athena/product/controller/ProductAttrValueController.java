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
 * @description spu属性值
 * @param: null
 * @date: 2022/7/28 12:21
 * @return:
 * @author: xjl
 */

@RestController
@RequestMapping("product/productattrvalue")
public class ProductAttrValueController {

    @Autowired
    private ProductAttrValueService productAttrValueService;

    /**
     * @description 查询的所有的数据
     * @param: params
     * @date: 2022/7/28 12:22
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:productattrvalue:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = productAttrValueService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id查询数据
     * @param: id
     * @date: 2022/7/28 12:22
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:productattrvalue:info")
    public Result info(@PathVariable("id") Long id) {
        ProductAttrValueEntity productAttrValue = productAttrValueService.getById(id);
        return Result.ok().put("productAttrValue", productAttrValue);
    }

    /**
     * @description 保存数据
     * @param: productAttrValue
     * @date: 2022/7/28 12:23
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:productattrvalue:save")
    public Result save(@RequestBody ProductAttrValueEntity productAttrValue) {
        productAttrValueService.save(productAttrValue);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: productAttrValue
     * @date: 2022/7/28 12:23
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:productattrvalue:update")
    public Result update(@RequestBody ProductAttrValueEntity productAttrValue) {
        productAttrValueService.updateById(productAttrValue);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 12:23
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //RequiresPermissions("product:productattrvalue:delete")
    public Result delete(@RequestBody Long[] ids) {
        productAttrValueService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
