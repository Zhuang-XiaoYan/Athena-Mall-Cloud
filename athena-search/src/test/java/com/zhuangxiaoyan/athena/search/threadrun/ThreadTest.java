package com.zhuangxiaoyan.athena.search.threadrun;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname ThreadTest
 * @Description 线程的创建测试与运行测试
 * @Date 2022/8/17 17:39
 *@author: xjl
 */

public class ThreadTest {

    /**
     * @description 手动的创建Thread类
     * @param: null
     * @date: 2022/8/17 17:22
     * @return:
     * @author: xjl
     */
    public static class ThreadRunTest extends Thread {
        @Override
        public void run() {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
        }
    }

    @Test
    public void mainTest() {
        ThreadRunTest threadRunTest = new ThreadRunTest();
        threadRunTest.start();
        System.out.println("主线程执行完成…………");
    }

    /**
     * @description 手动实现Runnable接口
     * @param: null
     * @date: 2022/8/17 17:23
     * @return:
     * @author: xjl
     */
    public static class RunableRunTest implements Runnable {
        @Override
        public void run() {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
        }
    }

    public static class CallableRunTest implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
            return i;
        }
    }

    /**
     * @description CallableaTest
     * @param: null
     * @date: 2022/8/17 19:52
     * @return:
     * @author: xjl
     */
    @Test
    public void CallableaTest() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableRunTest());
        new Thread(futureTask).start();
        // 等待线程完成 获取范湖结果 为阻塞等待
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}
