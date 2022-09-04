package com.zhuangxiaoyan.athena.cart.web;

import com.zhuangxiaoyan.athena.cart.service.CartService;
import com.zhuangxiaoyan.athena.cart.vo.CartItemVo;
import com.zhuangxiaoyan.athena.cart.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @description 购物车的controller
 * @date: 2022/9/3 7:49
 * @author: xjl
 */

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * @description 获取当前用户的购物车商品项
      * @param:
     * @date: 2022/9/4 8:04
     * @return: java.util.List<com.zhuangxiaoyan.athena.cart.vo.CartItemVo>
     * @author: xjl
    */
    @GetMapping(value = "/currentUserCartItems")
    @ResponseBody
    public List<CartItemVo> getCurrentCartItems() {
        List<CartItemVo> cartItemVoList = cartService.getUserCartItems();
        return cartItemVoList;
    }

    /**
     * @description
     * 去购物车页面的请求
     * 浏览器有一个cookie:user-key 标识用户的身份，一个月过期
     * 如果第一次使用jd的购物车功能，都会给一个临时的用户身份:
     * 浏览器以后保存，每次访问都会带上这个cookie；
     * 登录：session有
     * 没登录：按照cookie里面带来user-key来做
     * 第一次，如果没有临时用户，自动创建一个临时用户
     *
      * @param: model
     * @date: 2022/9/4 8:03
     * @return: java.lang.String
     * @author: xjl
    */
    @GetMapping(value = "/cart.html")
    public String cartListPage(Model model) throws ExecutionException, InterruptedException {
        //快速得到用户信息：id,user-key
        // UserInfoTo userInfoTo = CartInterceptor.toThreadLocal.get();
        CartVo cartVo = cartService.getCart();
        model.addAttribute("cart", cartVo);
        return "cartList";
    }

    /**
     * @description 添加商品到购物车
     * attributes.addFlashAttribute():将数据放在session中，可以在页面中取出，但是只能取一次
     * attributes.addAttribute():将数据放在url后面
      * @param: skuId
     * @param: num
     * @param: attributes
     * @date: 2022/9/4 8:03
     * @return: java.lang.String
     * @author: xjl
    */
    @GetMapping(value = "/addCartItem")
    public String addCartItem(@RequestParam("skuId") Long skuId, @RequestParam("num") Integer num, RedirectAttributes attributes) throws ExecutionException, InterruptedException {
        CartItemVo cartItemVo = cartService.addToCart(skuId, num);
        attributes.addAttribute("skuId", skuId);
        return "redirect:http://cart.athena.com/addToCartSuccessPage.html";
    }

    /**
     * @description 跳转到添加购物车成功页面 解决重复添加
      * @param: skuId
     * @param: model
     * @date: 2022/9/3 14:29
     * @return: java.lang.String
     * @author: xjl
    */
    @GetMapping(value = "/addToCartSuccessPage.html")
    public String addToCartSuccessPage(@RequestParam("skuId") Long skuId, Model model) {
        //重定向到成功页面。再次查询购物车数据即可
        CartItemVo cartItemVo = cartService.getCartItem(skuId);
        model.addAttribute("cartItem", cartItemVo);
        return "success";
    }

    /**
     * @description 商品是否选中
      * @param: skuId
     * @param: checked
     * @date: 2022/9/4 8:02
     * @return: java.lang.String
     * @author: xjl
    */
    @GetMapping(value = "/checkItem")
    public String checkItem(@RequestParam(value = "skuId") Long skuId, @RequestParam(value = "checked") Integer checked) {
        cartService.checkItem(skuId, checked);
        return "redirect:http://cart.athena.com/cart.html";

    }

    /**
     * @description 改变商品数量
      * @param: skuId
     * @param: num
     * @date: 2022/9/4 8:02
     * @return: java.lang.String
     * @author: xjl
    */
    @GetMapping(value = "/countItem")
    public String countItem(@RequestParam(value = "skuId") Long skuId, @RequestParam(value = "num") Integer num) {
        cartService.changeItemCount(skuId, num);
        return "redirect:http://cart.athena.com/cart.html";
    }

    /**
     * @description 删除商品信息
      * @param: skuId
     * @date: 2022/9/4 8:03
     * @return: java.lang.String
     * @author: xjl
    */
    @GetMapping(value = "/deleteItem")
    public String deleteItem(@RequestParam("skuId") Integer skuId) {
        cartService.deleteIdCartInfo(skuId);
        return "redirect:http://cart.athena.com/cart.html";
    }
}
