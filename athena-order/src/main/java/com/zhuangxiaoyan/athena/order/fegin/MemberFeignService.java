package com.zhuangxiaoyan.athena.order.fegin;


import com.zhuangxiaoyan.athena.order.vo.MemberAddressVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * @description TODO
  * @param: null
 * @date: 2022/9/6 9:13
 * @return:
 * @author: xjl
*/

@FeignClient("athena-member")
public interface MemberFeignService {

    /**
     * 查询当前用户的全部收货地址
     * @param memberId
     * @return
     */
    @GetMapping(value = "/member/memberreceiveaddress/{memberId}/address")
    List<MemberAddressVo> getAddress(@PathVariable("memberId") Long memberId);

}
