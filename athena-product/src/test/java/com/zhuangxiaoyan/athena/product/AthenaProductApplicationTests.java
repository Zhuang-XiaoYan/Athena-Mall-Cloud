package com.zhuangxiaoyan.athena.product;

import com.zhuangxiaoyan.athena.product.entity.BrandEntity;
import com.zhuangxiaoyan.athena.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description 单元测试中的两个的注解是原理是什么？如果没有会出现什么错误。为什么会出现的这样的错误。
 * @param: null
 * @date: 2022/3/9 22:43
 * @return:
 * @author: xjl
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class AthenaProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("庄小焱");
        brandEntity.setDescript("test service");
        brandService.save(brandEntity);
        System.out.println("保存成功……");
    }
}
