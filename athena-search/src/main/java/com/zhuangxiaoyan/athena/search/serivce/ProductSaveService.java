package com.zhuangxiaoyan.athena.search.serivce;

import com.zhuangxiaoyan.athena.search.to.SkuEsModelTo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Description ProductSaveService
 * @Date 2022/8/2 9:22
 * @Created by xjl
 */
public interface ProductSaveService {

    /**
     * @description 商品的上架功能
     * @param: skuEsModelTos
     * @date: 2022/8/2 9:24
     * @return: void
     * @author: xjl
     */
    boolean productStateUp(List<SkuEsModelTo> skuEsModelTos) throws IOException;
}
