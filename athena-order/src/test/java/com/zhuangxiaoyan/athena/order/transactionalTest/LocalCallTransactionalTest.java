package com.zhuangxiaoyan.athena.order.transactionalTest;

import org.springframework.aop.framework.AopContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname LocalCallTransactionalTest
 * @Description 本类中事务相互调用失效与解决方案
 *  在本类中的相互调用失效的时候 可以是aspect 即使没有的接口也是构建代理
 * @Date 2022/9/12 14:14
 * @Created by xjl
 */

public class LocalCallTransactionalTest {

    @Transactional(timeout = 20)
    public void aTest(){
        bTest(); // 事务失效
        cTest(); // 事务失效
        System.out.println("----------a----------------");
        LocalCallTransactionalTest localCallTransactional = (LocalCallTransactionalTest) AopContext.currentProxy();
        localCallTransactional.bTest();
        localCallTransactional.cTest();

    }

    @Transactional(timeout = 20,propagation = Propagation.REQUIRED)
    public void bTest(){
        System.out.println("----------b----------------");
    }

    @Transactional(timeout = 20,propagation = Propagation.REQUIRES_NEW)
    public void cTest(){
        System.out.println("----------c----------------");
    }

}
