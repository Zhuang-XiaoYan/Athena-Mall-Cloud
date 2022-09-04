package com.zhuangxiaoyan.athena.cart.service;

import com.zhuangxiaoyan.athena.cart.vo.CartItemVo;
import com.zhuangxiaoyan.athena.cart.vo.CartVo;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @description 购物车的接口
 * @date: 2022/9/3 7:34
 * @author: xjl
 */
public interface CartService {

    /**
     * @description 将商品添加至购物车
     * @param: skuId
     * @param: num
     * @date: 2022/9/3 7:35
     * @return: com.zhuangxiaoyan.athena.cart.vo.CartItemVo
     * @author: xjl
     */
    CartItemVo addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException;

    /**
     * @description 获取购物车某个购物项
     * @param: skuId
     * @date: 2022/9/3 7:35
     * @return: com.zhuangxiaoyan.athena.cart.vo.CartItemVo
     * @author: xjl
     */
    CartItemVo getCartItem(Long skuId);

    /**
     * @description 获取购物车里面的信息
     * @param:
     * @date: 2022/9/3 7:35
     * @return: com.zhuangxiaoyan.athena.cart.vo.CartVo
     * @author: xjl
     */
    CartVo getCart() throws ExecutionException, InterruptedException;

    /**
     * @description 清空购物车的数据
     * @param: cartKey
     * @date: 2022/9/3 7:35
     * @return: void
     * @author: xjl
     */
    public void clearCartInfo(String cartKey);

    /**
     * @description 勾选购物项
     * @param: skuId
     * @param: check
     * @date: 2022/9/3 7:35
     * @return: void
     * @author: xjl
     */
    void checkItem(Long skuId, Integer check);

    /**
     * @description 改变商品数量
     * @param: skuId
     * @param: num
     * @date: 2022/9/3 7:35
     * @return: void
     * @author: xjl
     */
    void changeItemCount(Long skuId, Integer num);

    /**
     * @description 删除购物项
     * @param: skuId
     * @date: 2022/9/3 7:35
     * @return: void
     * @author: xjl
     */
    void deleteIdCartInfo(Integer skuId);

    /**
     * @description 获取用户的购物车
     * @param:
     * @date: 2022/9/3 7:34
     * @return: java.util.List<com.zhuangxiaoyan.athena.cart.vo.CartItemVo>
     * @author: xjl
     */
    List<CartItemVo> getUserCartItems();

}
