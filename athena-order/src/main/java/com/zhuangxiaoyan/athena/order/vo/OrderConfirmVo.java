package com.zhuangxiaoyan.athena.order.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @description TODO
 * @param: null
 * @date: 2022/9/6 9:03
 * @return:
 * @author: xjl
 */
@Data
public class OrderConfirmVo {

    /** 会员收获地址列表 **/
    List<MemberAddressVo> memberAddressVos;

    /** 所有选中的购物项 **/
    List<OrderItemVo> items;

    /** 发票记录 **/
    /** 优惠券（会员积分） **/
    private Integer integration;

    /** 防止重复提交的令牌 **/
    private String orderToken;

    Map<Long,Boolean> stocks;

    /**
     * @description 获取商品总件数
      * @param:
     * @date: 2022/9/8 8:37
     * @return: java.lang.Integer
     * @author: xjl
    */
    public Integer getCount() {
        Integer count = 0;
        if (items != null && items.size() > 0) {
            for (OrderItemVo item : items) {
                count += item.getCount();
            }
        }
        return count;
    }


    /**
     * @description 计算订单总额
      * @param:
     * @date: 2022/9/8 8:38
     * @return: java.math.BigDecimal
     * @author: xjl
    */
    public BigDecimal getTotal() {
        BigDecimal totalNum = BigDecimal.ZERO;
        if (items != null && items.size() > 0) {
            for (OrderItemVo item : items) {
                //计算当前商品的总价格
                BigDecimal itemPrice = item.getPrice().multiply(new BigDecimal(item.getCount().toString()));
                //再计算全部商品的总价格
                totalNum = totalNum.add(itemPrice);
            }
        }
        return totalNum;
    }

    /** 应付价格 **/
    //BigDecimal payPrice;
    public BigDecimal getPayPrice() {
        return getTotal();
    }
}
