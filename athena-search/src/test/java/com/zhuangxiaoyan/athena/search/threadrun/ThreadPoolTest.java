package com.zhuangxiaoyan.athena.search.threadrun;

import java.util.concurrent.*;

/**
 * @Classname ThreadPoolTest
 * @Description 线程池的创建测试与运行测试
 * @Date 2022/8/17 17:39
 *@author: xjl
 */

public class ThreadPoolTest {

    /**
     * @description 保证系统中一定数量的线程池 固定线程池
     */
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    /**
     * @description 测试线程池的的创建爱
     * @param:
     * @date: 2022/8/17 17:20
     * @return: void
     * @author: xjl
     */
    private static void threadPool() {
        ExecutorService threadPool = new ThreadPoolExecutor(
                200,
                10,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(10000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        // 定时任务的线程池
        ExecutorService Scheduledservice = Executors.newScheduledThreadPool(2);
        // 缓存线程池
        ExecutorService Cachedexecutor = Executors.newCachedThreadPool();
        // 固定的线程池
        ExecutorService Fixedexecutor = Executors.newFixedThreadPool(10);
        // 单线程的线程池
        ExecutorService Singleexecutor = Executors.newSingleThreadExecutor();
    }
}
