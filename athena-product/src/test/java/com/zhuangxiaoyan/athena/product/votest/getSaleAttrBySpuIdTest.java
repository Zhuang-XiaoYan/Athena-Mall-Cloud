package com.zhuangxiaoyan.athena.product.votest;

import com.zhuangxiaoyan.athena.product.dao.SkuSaleAttrValueDao;
import com.zhuangxiaoyan.athena.product.vo.SkuItemSaleAttrVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Classname getSaleAttrBySpuIdTest
 * @Description TODO
 * @Date 2022/8/21 8:40
 * @Created by xjl
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class getSaleAttrBySpuIdTest {

    @Autowired
    SkuSaleAttrValueDao skuSaleAttrValueDao;

    @Test
    public void test() {
        List<SkuItemSaleAttrVo> saleAttrBySpuId = skuSaleAttrValueDao.getSaleAttrBySpuId(13L);
        saleAttrBySpuId.forEach(System.out::println);
    }
}
