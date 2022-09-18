package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.SpuInfoEntity;
import com.zhuangxiaoyan.athena.product.service.SpuInfoService;
import com.zhuangxiaoyan.athena.product.vo.SpuSaveVo;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @description spu信息
 * @param: null
 * @date: 2022/7/28 12:46
 * @return:
 * @author: xjl
 */

@RestController
@RequestMapping("product/spuinfo")
public class SpuInfoController {

    @Autowired
    private SpuInfoService spuInfoService;


    @GetMapping(value = "/skuId/{skuId}")
    Result getSpuInfoBySkuId(@PathVariable("skuId") Long skuId){
        SpuInfoEntity spuInfoEntity=spuInfoService.getSpuInfoBySkuId(skuId);
        return Result.ok().setData(spuInfoEntity);
    }

    /**
     * @description 将数据的上传到的es中
      * @param: spuId
     * @date: 2022/8/1 21:03
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @PostMapping("/{spuId}/up")
    public Result spuInfoUp(@PathVariable("spuId") Long spuId) {
        spuInfoService.spusavees(spuId);
        return Result.ok();
    }

    /**
     * @description: 查询所有的数据
     * @param: params
     * @date: 2022/7/28 12:46
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuinfo:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = spuInfoService.queryPageByCondition(params);
        return Result.ok().put("page", page);
    }

    /**
     * @description 通过id进行查询
     * @param: id
     * @date: 2022/7/28 12:47
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:spuinfo:info")
    public Result info(@PathVariable("id") Long id) {
        SpuInfoEntity spuInfo = spuInfoService.getById(id);
        return Result.ok().put("skuInfo", spuInfo);
    }

    /**
     * @description 保存信息数据
     * @param: spuSaveVo
     * @date: 2022/7/28 12:48
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spuinfo:save")
    public Result save(@RequestBody SpuSaveVo spuSaveVo) {
        spuInfoService.saveSpuInfo(spuSaveVo);
        return Result.ok();
    }

    /**
     * @description 更新数据
     * @param: spuInfo
     * @date: 2022/7/28 12:48
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:spuinfo:update")
    public Result update(@RequestBody SpuInfoEntity spuInfo) {
        spuInfoService.updateById(spuInfo);
        return Result.ok();
    }

    /**
     * @description 删除数据
     * @param: ids
     * @date: 2022/7/28 12:48
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spuinfo:delete")
    public Result delete(@RequestBody Long[] ids) {
        spuInfoService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

}
