package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.ProductAttrValueEntity;
import com.zhuangxiaoyan.athena.product.service.AttrService;
import com.zhuangxiaoyan.athena.product.service.ProductAttrValueService;
import com.zhuangxiaoyan.athena.product.vo.AttrRespVo;
import com.zhuangxiaoyan.athena.product.vo.AttrVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-09 21:43:56
 */
@Slf4j
@RestController
@RequestMapping("product/attr")
public class AttrController {

    @Autowired
    private AttrService attrService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @GetMapping("/base/listforspu/{spuId}")
    public Result baseAttrListSpu(@PathVariable("spuId") Long spuId) {
        List<ProductAttrValueEntity> lists=productAttrValueService.baseAttrListSpu(spuId);
        return Result.ok().put("data", lists);
    }

    @GetMapping("/{attrType}/list/{catelogId}")
    public Result baseAttrList(@RequestParam Map<String, Object> params, @PathVariable("catelogId") Long catelogId,
                               @PathVariable("attrType") String attrType) {
        PageUtils page = attrService.queryBaseAttrQuery(params, catelogId, attrType);
        return Result.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public Result info(@PathVariable("attrId") Long attrId) {
        AttrRespVo attrRespVo = attrService.getAttrInfo(attrId);
        return Result.ok().put("attr", attrRespVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public Result save(@RequestBody AttrVo attrVo) {
        attrService.saveAttr(attrVo);
        return Result.ok();
    }

    /**
     * 更新数据
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public Result update(@RequestBody AttrVo attrVo) {
        attrService.updateAttr(attrVo);
        return Result.ok();
    }

    /**
     * 批量更新的操作
     */
    @PostMapping("/update/{spuId}")
    //@RequiresPermissions("product:attr:update")
    public Result updateSpuAttr(@PathVariable("spuId") Long spuId,@RequestBody List<ProductAttrValueEntity> entities) {
        productAttrValueService.updateSpuAttr(spuId,entities);
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public Result delete(@RequestBody Long[] attrIds) {
        attrService.removeByIds(Arrays.asList(attrIds));
        return Result.ok();
    }
}
