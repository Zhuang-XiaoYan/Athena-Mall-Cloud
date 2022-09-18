package com.zhuangxiaoyan.athena.order.fegin;

import com.zhuangxiaoyan.athena.order.vo.PayVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @description TODO
  * @param: null
 * @date: 2022/9/6 9:13
 * @return:
 * @author: xjl
*/

@FeignClient("athena-pay")
public interface PayFeignService {

    @GetMapping(value = "/pay",consumes = "application/json")
    String pay(@RequestBody PayVo vo);

}
