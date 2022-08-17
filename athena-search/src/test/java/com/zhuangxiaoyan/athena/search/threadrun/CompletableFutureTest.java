package com.zhuangxiaoyan.athena.search.threadrun;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname CompletableFutureTest
 * @Description CompletableFuture的语法功能测试
 * @Date 2022/8/17 17:39
 * @Created by xjl
 */

public class CompletableFutureTest {

    public static ExecutorService fixedexecutorService = Executors.newFixedThreadPool(10);

    @Test
    public void runAsyncTest() {
        System.out.println("main run start…………");
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
        }, fixedexecutorService);
        System.out.println("main run end…………");
    }

    /**
     * @description 对异步的异常做感知和处理
     * @param:
     * @date: 2022/8/17 20:54
     * @return: void
     * @author: xjl
     */
    @Test
    public void supplyAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 0;
            System.out.println("运行结果：" + i);
            return i;
        }, fixedexecutorService).whenComplete((result, exception) -> {
            // 虽然能够得到异常信息，但是的没有办法的修改数据返回数据
            System.out.println("异步任务完成成功…………结果是" + result + "异常是：" + exception);
        }).exceptionally(throwable -> {
            // 可以感知异常，同时也是可以修改默认值
            return 10;
        });
        System.out.println("main run end…………" + future.get());
    }

    /**
     * @description对异步的方法做处理
     * @param:
     * @date: 2022/8/17 20:50
     * @return: void
     * @author: xjl
     */
    @Test
    public void handleTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 5;
            System.out.println("运行结果：" + i);
            return i;
        }, fixedexecutorService).handle((result, throwable) -> {
            if (result != null) {
                return result * 2;
            }
            if (throwable != null) {
                return 0;
            }
            return 0;
        });
        System.out.println("main run end…………" + future.get());
    }

    /**
     * @description thenRunAsync 不能获取上一步的结果
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void thenRunAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 5;
            System.out.println("运行结果：" + i);
            return i;
        }, fixedexecutorService).thenRunAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
        }, fixedexecutorService);
        System.out.println("main run end…………");
    }

    /**
     * @description thenRunAsync 不能获取上一步的结果 danshi 但是无返回值
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void thenAcceptAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 5;
            System.out.println("运行结果：" + i);
            return i;
        }, fixedexecutorService).thenAcceptAsync((result) -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = result * 10;
            System.out.println("运行结果：" + i);
        }, fixedexecutorService);
        System.out.println("main run end…………");
    }

    /**
     * @description thenRunAsync 不能获取上一步的结果 danshi 但是无返回值
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void thenApplyAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 5;
            System.out.println("运行结果：" + i);
            return i;
        }, fixedexecutorService).thenApplyAsync((result) -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int res = result * 10 + 100;
            System.out.println("运行结果：" + res);
            return res;
        }, fixedexecutorService);
        System.out.println("main run end…………" + future.get());
    }

    /**
     * @description runAfterBothAsync 不能感知到结果的
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void runAfterBothAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 5;
            System.out.println("task1 运行结果：" + i);
            return i;
        }, fixedexecutorService);

        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task2 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 4;
            System.out.println("task2 运行结果：" + i);
            return i;
        }, fixedexecutorService);

        task1.runAfterBothAsync(task2, () -> {
            System.out.println("task3 当前线程：" + Thread.currentThread().getId());
            int i = 10;
            System.out.println("task3 运行结果：" + i);
        }, fixedexecutorService);
        System.out.println("main run end…………");
    }

    /**
     * @description runAfterBothAsync 不能感知到结果的
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void thenAccpetBothTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 5;
            System.out.println("task1 运行结果：" + i);
            return i;
        }, fixedexecutorService);

        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task2 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 4;
            System.out.println("task2 运行结果：" + i);
            return i;
        }, fixedexecutorService);

        task1.thenAcceptBothAsync(task2, (res1, res2) -> {
            System.out.println("task3 当前线程：" + Thread.currentThread().getId());
            int i = res1 * res2;
            System.out.println("task3 运行结果：" + i);
        }, fixedexecutorService);
        System.out.println("main run end…………");
    }

    /**
     * @description runAfterBothAsync 合并多个任务
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void thenCombineAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        // task1
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 5;
            System.out.println("task1 运行结果：" + i);
            return i;
        }, fixedexecutorService);
        // task2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task2 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 4;
            System.out.println("task2 运行结果：" + i);
            return i;
        }, fixedexecutorService);
        // task3
        CompletableFuture<Integer> task3 = task1.thenCombineAsync(task2, (res1, res2) -> {
            System.out.println("task3 当前线程：" + Thread.currentThread().getId());
            int i = res1 * res2;
            System.out.println("task3 运行结果：" + i);
            return i;
        }, fixedexecutorService);
        System.out.println("task3=" + task3.get());
        System.out.println("main run end…………");
    }

    /**
     * @description runAfterEitherAsyncTest 不敢直接过 也没有返回值
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void runAfterEitherAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        // task1
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 5;
            System.out.println("task1 运行结束结果：" + i);
            return i;
        }, fixedexecutorService);
        // task2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task2 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 4;
            try {
                Thread.sleep(10000);
                System.out.println("task2 运行结束结果：" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i;
        }, fixedexecutorService);
        task1.runAfterEitherAsync(task2, () -> {
            System.out.println("task3 当前线程：" + Thread.currentThread().getId());
            int i = 1000;
            System.out.println("task3 运行结束结果：" + i);
        }, fixedexecutorService);
        System.out.println("main run end…………");
    }

    /**
     * @description runAfterEitherAsyncTest 不敢直接过 也没有返回值
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void acceptEitherAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        // task1
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 5;
            System.out.println("task1 运行结束结果：" + i);
            return i;
        }, fixedexecutorService);
        // task2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task2 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 4;
            System.out.println("task2 运行结束结果：" + i);
            return i;
        }, fixedexecutorService);
        task1.acceptEitherAsync(task2, (result) -> {
            System.out.println("task3 当前线程：" + Thread.currentThread().getId());
            int i = 1000 + result;
            System.out.println("task3 运行结束结果：" + i);
        }, fixedexecutorService);
        System.out.println("main run end…………");
    }


    /**
     * @description runAfterEitherAsyncTest 不敢直接过 也没有返回值
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void applyToEitherAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        // task1
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 5;
            System.out.println("task1 运行结束结果：" + i);
            return i;
        }, fixedexecutorService);
        // task2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task2 当前线程：" + Thread.currentThread().getId());
            int i = 10 / 4;
            System.out.println("task2 运行结束结果：" + i);
            return i;
        }, fixedexecutorService);
        CompletableFuture<Integer> task3 = task1.applyToEitherAsync(task2, (result) -> {
            System.out.println("task3 当前线程：" + Thread.currentThread().getId());
            int i = 1000 + result;
            System.out.println("task3 运行结束结果：" + i);
            return i;
        }, fixedexecutorService);
        System.out.println(task3.get());
        System.out.println("main run end…………");
    }

    /**
     * @description runAfterEitherAsyncTest 不敢直接过 也没有返回值
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void allOfTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        // task1
        CompletableFuture<String> task1Img = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1Img");
            return "task1Img";
        }, fixedexecutorService);

        CompletableFuture<String> task2Pro= CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("task2Pro");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task2Pro";
        }, fixedexecutorService);

        CompletableFuture<String> task3Info= CompletableFuture.supplyAsync(() -> {
            System.out.println("task3Info");
            return "task3Info";
        }, fixedexecutorService);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(task1Img, task2Pro, task3Info);
        // 等待所有的结果的完成
        allOf.get();// allOf.join();
        System.out.println("main run end…………");
    }

    /**
     * @description runAfterEitherAsyncTest 不敢直接过 也没有返回值
     * @param:
     * @date: 2022/8/17 21:00
     * @return: void
     * @author: xjl
     */
    @Test
    public void anyOfTest() throws ExecutionException, InterruptedException {
        System.out.println("main run start…………");
        // task1
        CompletableFuture<String> task1Img = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1Img");
            return "task1Img";
        }, fixedexecutorService);

        CompletableFuture<String> task2Pro= CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("task2Pro");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task2Pro";
        }, fixedexecutorService);

        CompletableFuture<String> task3Info= CompletableFuture.supplyAsync(() -> {
            System.out.println("task3Info");
            return "task3Info";
        }, fixedexecutorService);

        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(task1Img, task2Pro, task3Info);
        // 等待所有的结果的完成
        anyOf.get();// allOf.join();
        System.out.println("main run end…………");
    }
}