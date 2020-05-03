package com.syygl.test.study.threadTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by sunyy on 2020/4/28.
 * <p>
 * 注意函数式编程与链式编程
 * 从CompletableFuture的定义可以看出他
 * 即是 Future<T>（结果集）
 * 又是CompletionStage<T>（完成的中间状态，可以继续执行，也可以结束）
 * 所以在对CompletableFuture进行操作时根据需要选择需要的步骤
 * FIFO  first in first out   队列
 * LIFO last in first out     栈
 */
public class SyyTest4CompletableFuture {


    public static void main(String[] args) {
        testForkJoinPool();


    }

    private static void testForkJoinPool() {
        CompletableFuture[] completableFutures = new CompletableFuture[100];
        for (int i = 0; i < 100; i++) {
            CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "123";
            });
            completableFutures[i] = stringCompletableFuture;
        }

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        voidCompletableFuture.join();

    }


    private static void testCompletableFuture() {
        /**
         CompletableFuture.supplyAsync();   有返回结果
         CompletableFuture.runAsync()       无返回结果
         */

        System.out.println("CPU=" + Runtime.getRuntime().availableProcessors());

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.threadFactory",YourForkJoinWorkerThreadFactory.class.getName());
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.exceptionHandler",YourUncaughtExceptionHandler.class.getName());

        //使用默认的线程池  asyncPool -> ForkJoinPool.commonPool()
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            return "test1";
        });

        cf.join();
    }
}
