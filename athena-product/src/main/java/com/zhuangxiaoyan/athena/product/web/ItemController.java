package com.zhuangxiaoyan.athena.product.web;

import com.zhuangxiaoyan.athena.product.service.SkuInfoService;
import com.zhuangxiaoyan.athena.product.vo.SkuItemVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @Classname ItemController
 * @Description TODO
 * @Date 2022/8/20 0:03
 * @Created by xjl
 */

@Controller
public class ItemController {

    @Resource
    private SkuInfoService skuInfoService;

    /**
     * @description 展示当前sku的详情页面
      * @param: skuId
     * @param: model
     * @date: 2022/8/20 0:06
     * @return: java.lang.String
     * @author: xjl
    */
    @GetMapping("/{skuId}.html")
    public String skuItemPage(@PathVariable("skuId") Long skuId, Model model) throws ExecutionException, InterruptedException {
        System.out.println("准备查询" + skuId + "详情");
        SkuItemVo vos = skuInfoService.itemPage(skuId);
        model.addAttribute("item",vos);
        return "item";
    }
}
