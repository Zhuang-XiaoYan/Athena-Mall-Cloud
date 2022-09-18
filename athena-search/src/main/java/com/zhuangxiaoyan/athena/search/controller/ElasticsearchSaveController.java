package com.zhuangxiaoyan.athena.search.controller;

import com.zhuangxiaoyan.athena.search.serivce.ProductSaveService;
import com.zhuangxiaoyan.athena.search.to.SkuEsModelTo;
import com.zhuangxiaoyan.common.exception.ExceptionCode;
import com.zhuangxiaoyan.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description ElasticsearchSaveController
 * @Date 2022/8/2 9:18
 *@author: xjl
 */

@Slf4j
@RestController
@RequestMapping(value = "/search/save")
public class ElasticsearchSaveController {

    @Autowired
    private ProductSaveService productSaveService;

    @PostMapping(value = "/product")
    public Result productStateSave(@RequestBody List<SkuEsModelTo> skuEsModelTos) {
        try {
            productSaveService.productStateUp(skuEsModelTos);
            return Result.ok();
        } catch (Exception e) {
            log.error("商品上架的失败");
            return Result.error(ExceptionCode.PRODUCT_UP_EXCEPTION.getCode(), ExceptionCode.PRODUCT_UP_EXCEPTION.getMessage());
        }
    }
}
