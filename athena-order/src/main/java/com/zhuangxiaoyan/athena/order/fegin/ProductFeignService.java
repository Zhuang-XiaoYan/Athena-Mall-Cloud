package com.zhuangxiaoyan.athena.order.fegin;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description TODO
  * @param: null
 * @date: 2022/9/6 9:13
 * @return:
 * @author: xjl
*/

@FeignClient("athena-product")
public interface ProductFeignService {

    /**
     * 根据skuId查询spu的信息
     * @param skuId
     * @return
     */
    @GetMapping(value = "/product/spuinfo/skuId/{skuId}")
    Result getSpuInfoBySkuId(@PathVariable("skuId") Long skuId);

}
