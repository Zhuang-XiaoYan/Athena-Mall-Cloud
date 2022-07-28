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
 * @description 商品属性
 * @date: 2022/7/28 10:37
 * @return:
 * @author: xjl
 */

@Slf4j
@RestController
@RequestMapping("product/attr")
public class AttrController {

    @Autowired
    private AttrService attrService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    /**
     * @description 查询的spu列表的详细信息
     * @param: spuId
     * @date: 2022/7/28 10:37
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @GetMapping("/base/listforspu/{spuId}")
    public Result baseAttrListSpu(@PathVariable("spuId") Long spuId) {
        List<ProductAttrValueEntity> lists = productAttrValueService.baseAttrListSpu(spuId);
        return Result.ok().put("data", lists);
    }

    /**
     * @description 查询分类列表的详细
     * @param: params
     * @param: catelogId
     * @param: attrType
     * @date: 2022/7/28 10:38
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @GetMapping("/{attrType}/list/{catelogId}")
    public Result baseAttrList(@RequestParam Map<String, Object> params, @PathVariable("catelogId") Long catelogId, @PathVariable("attrType") String attrType) {
        PageUtils page = attrService.queryBaseAttrQuery(params, catelogId, attrType);
        return Result.ok().put("page", page);
    }

    /**
     * @description 属性列表信息
     * @param: null
     * @date: 2022/7/28 10:38
     * @return:
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrService.queryPage(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 查询attrId信息
     * @param: null
     * @date: 2022/7/28 10:39
     * @return:
     * @author: xjl
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public Result info(@PathVariable("attrId") Long attrId) {
        AttrRespVo attrRespVo = attrService.getAttrInfo(attrId);
        return Result.ok().put("attr", attrRespVo);
    }

    /**
     * @description 保存
     * @param: null
     * @date: 2022/7/28 10:40
     * @return:
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public Result save(@RequestBody AttrVo attrVo) {
        attrService.saveAttrVo(attrVo);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: attrVo
     * @date: 2022/7/28 10:40
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public Result update(@RequestBody AttrVo attrVo) {
        attrService.updateAttr(attrVo);
        return Result.ok();
    }

    /**
     * @description 批量更新操作
     * @param: spuId
     * @param: entities
     * @date: 2022/7/28 10:40
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @PostMapping("/update/{spuId}")
    //@RequiresPermissions("product:attr:update")
    public Result updateSpuAttr(@PathVariable("spuId") Long spuId, @RequestBody List<ProductAttrValueEntity> entities) {
        productAttrValueService.updateSpuAttr(spuId, entities);
        return Result.ok();
    }

    /**
     * @description 删除操作
     * @param: attrIds
     * @date: 2022/7/28 10:40
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public Result delete(@RequestBody Long[] attrIds) {
        attrService.removeByIds(Arrays.asList(attrIds));
        return Result.ok();
    }
}
