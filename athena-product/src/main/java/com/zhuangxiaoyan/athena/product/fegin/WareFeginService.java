package com.zhuangxiaoyan.athena.product.fegin;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description WareFeginService
 * @Date 2022/8/1 23:06
 *@author: xjl
 */
@FeignClient("athena-ware")
public interface WareFeginService {


    @RequestMapping("/ware/waresku/hasstock")
    Result querySkuHasStock(@RequestBody List<Long> skuIds);
}
