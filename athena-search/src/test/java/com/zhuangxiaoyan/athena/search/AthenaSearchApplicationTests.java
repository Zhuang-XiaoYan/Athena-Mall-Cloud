package com.zhuangxiaoyan.athena.search;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AthenaSearchApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * @description 测试es的环境是否准备完成
      * @param:
     * @date: 2022/7/31 17:25
     * @return: void
     * @author: xjl
    */
    @Test
    public void contextLoads() {
        System.out.println("restHighLevelClient value=" + restHighLevelClient);
    }

}
