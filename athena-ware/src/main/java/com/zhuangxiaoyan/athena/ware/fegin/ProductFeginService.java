package com.zhuangxiaoyan.athena.ware.fegin;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ProductFeginService
 * @Description 远程商品的调用的接口
 * @Date 2022/7/27 9:17
 * @Created by xjl
 */
@FeignClient("athena-product")
public interface ProductFeginService {

    @RequestMapping("/product/spuinfo/info/{skuId}")
    public Result info(@PathVariable("skuId") Long id);
}
