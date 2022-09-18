package com.zhuangxiaoyan.athena.ware.fegin;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description TODO
  * @param: null
 * @date: 2022/9/17 20:43
 * @return:
 * @author: xjl
*/

@FeignClient("athena-order")
public interface OrderFeignService {

    @GetMapping(value = "/order/order/status/{orderSn}")
    Result getOrderStatus(@PathVariable("orderSn") String orderSn);

}
