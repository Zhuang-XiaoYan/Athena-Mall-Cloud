package com.zhuangxiaoyan.athena.cart.fegin;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname ProductFeignService
 * @Date 2022/9/3 7:43
 * @Created by xjl
 */

@FeignClient("athena-product")
public interface ProductFeignService {

    /**
     * @description TODO
      * @param: skuId
     * @date: 2022/9/4 8:50
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
    */
    @RequestMapping("/product/skuinfo/info/{skuId}")
    Result info(@PathVariable("skuId") Long skuId);

    /**
     * @description TODO
      * @param: skuId
     * @date: 2022/9/4 8:50
     * @return: java.util.List<java.lang.String>
     * @author: xjl
    */
    @GetMapping("/stringlist/{skuId}")
    List<String> getSkuSaleAttrValues(@PathVariable("skuId") Long skuId);

    /**
     * @description 根据skuId查询当前商品的最新价格
      * @param: skuId
     * @date: 2022/9/4 8:50
     * @return: java.math.BigDecimal
     * @author: xjl
    */
    @GetMapping(value = "/product/skuinfo/{skuId}/price")
    BigDecimal getPrice(@PathVariable("skuId") Long skuId);
}
