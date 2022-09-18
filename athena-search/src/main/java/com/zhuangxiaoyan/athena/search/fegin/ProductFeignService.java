package com.zhuangxiaoyan.athena.search.fegin;

import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description ProductFeignService
 * @Date 2022/8/16 11:38
 *@author: xjl
 */

@FeignClient("athena-product")
public interface ProductFeignService {
    /**
     * @description 远程调用的查询
     * @param: attrId
     * @date: 2022/8/16 20:07
     * @return: com.zhuangxiaoyan.common.utils.Result
     * @author: xjl
     */
    @GetMapping("/product/attr/info/{attrId}")
    Result attrInfo(@PathVariable("attrId") Long attrId);

}
