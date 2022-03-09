package com.zhuangxiaoyan.athena.product.EntityUnitTest;

import com.zhuangxiaoyan.athena.product.entity.BrandEntity;
import com.zhuangxiaoyan.athena.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Classname BrandServiceUnitTest
 * @Description BrandService 单元测试类
 * @Date 2022/3/9 22:47
 * @Created by xjl
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandServiceUnitTest {

    @Autowired
    BrandService brandService;


    @Test
    void save(){
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("庄小焱");
        brandEntity.setDescript("test service");
        brandService.save(brandEntity);
        System.out.println("保存成功……");
    }

    @Test
    void update(){

    }

    @Test
    void find(){

    }

    @Test
    void delete(){

    }

}
