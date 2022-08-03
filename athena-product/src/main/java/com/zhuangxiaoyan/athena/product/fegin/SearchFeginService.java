package com.zhuangxiaoyan.athena.product.fegin;

import com.zhuangxiaoyan.athena.product.to.SkuEsModelTo;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Classname SearchFeginService
 * @Description TODO
 * @Date 2022/8/3 10:44
 * @Created by xjl
 */
@FeignClient("athena-search")
public interface SearchFeginService {

    @PostMapping("/search/save/product")
    Result productStateUp(@RequestBody List<SkuEsModelTo> skuEsModelTos);
}
