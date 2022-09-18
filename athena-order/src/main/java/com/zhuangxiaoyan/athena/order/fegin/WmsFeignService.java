package com.zhuangxiaoyan.athena.order.fegin;

import com.baomidou.mybatisplus.extension.api.R;
import com.zhuangxiaoyan.athena.order.vo.WareSkuLockVo;
import com.zhuangxiaoyan.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description TODO
 * @param: null
 * @date: 2022/9/6 9:14
 * @return:
 * @author: xjl
 */

@FeignClient("athena-ware")
public interface WmsFeignService {

    /**
     * 查询sku是否有库存
     *
     * @return
     */
    @PostMapping("/hasstock")
    Result querySkuHasStock(@RequestBody List<Long> skuIds);
    /**
     * 查询运费和收货地址信息
     *
     * @param addrId
     * @return
     */
    @GetMapping(value = "/ware/wareinfo/fare")
    Result getFare(@RequestParam("addrId") Long addrId);

    /**
     * 锁定库存
     *
     * @param vo
     * @return
     */
    @PostMapping(value = "/ware/waresku/lock/order")
    Result orderLockStock(@RequestBody WareSkuLockVo vo);
}
