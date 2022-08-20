package com.zhuangxiaoyan.athena.product;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.zhuangxiaoyan.athena.product.dao.AttrGroupDao;
import com.zhuangxiaoyan.athena.product.entity.BrandEntity;
import com.zhuangxiaoyan.athena.product.service.BrandService;
import com.zhuangxiaoyan.athena.product.service.CategoryService;
import com.zhuangxiaoyan.athena.product.vo.SpuItemAttrGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @description 单元测试中的两个的注解是原理是什么？如果没有会出现什么错误。为什么会出现的这样的错误。
 * @param: null
 * @date: 2022/3/9 22:43
 * @return:
 * @author: xjl
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AthenaProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    private AttrGroupDao attrGroupDao;

    @Test
    public void getAttrGroupWithAttrsBySpuIdTest() {
        List<SpuItemAttrGroupVo> attrGroupWithAttrsBySpuId = attrGroupDao.getAttrGroupWithAttrsBySpuId(13L, 225L);
        attrGroupWithAttrsBySpuId.forEach(System.out::println);
    }

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("庄小焱");
        brandEntity.setDescript("test service");
        brandService.save(brandEntity);
        System.out.println("保存成功……");
    }

    @Test
    public void categoryServiceTest() {
        Long[] categlogPath = categoryService.findCateglogPath(225L);
        log.info("完整的路径是：{}", Arrays.asList(categlogPath));
    }

    @Test
    public void redisTest() {
        ValueOperations<String, String> client = stringRedisTemplate.opsForValue();
        //向redis添加数据
        client.set("name", "庄小焱" + UUID.randomUUID().toString());
        // redis查询数据
        String name = client.get("name");
        System.out.println("name==" + name);
    }

    @Test
    public void redissonClientTest(){
        System.out.println(redissonClient);
    }
}
