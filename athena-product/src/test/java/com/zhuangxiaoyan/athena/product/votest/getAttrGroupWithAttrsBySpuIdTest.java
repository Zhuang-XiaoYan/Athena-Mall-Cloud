package com.zhuangxiaoyan.athena.product.votest;

import com.zhuangxiaoyan.athena.product.dao.AttrGroupDao;
import com.zhuangxiaoyan.athena.product.vo.SpuItemAttrGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname getAttrGroupWithAttrsBySpuIdTest
 * @Description getAttrGroupWithAttrsBySpuIdTest
 * @Date 2022/8/20 23:24
 * @Created by xjl
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class getAttrGroupWithAttrsBySpuIdTest {

    @Autowired
    private AttrGroupDao attrGroupDao;

    @Test
    public void test() {
        List<SpuItemAttrGroupVo> attrGroupWithAttrsBySpuId = attrGroupDao.getAttrGroupWithAttrsBySpuId(13L, 225L);
        attrGroupWithAttrsBySpuId.forEach(System.out::println);
    }
}
