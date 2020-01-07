package com.syygl.test.study.threadTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * JDK8线程池-ThreadPoolExecutor动态调整corePoolSize与maximumPoolSize
 * https://blog.csdn.net/fenglllle/article/details/84473345
 * Created by sunyy on 2020/1/3.
 */
public class Test {
    public void testThreadPool() {
        BlockingQueue blockingQueue = new LinkedBlockingQueue(100);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, blockingQueue);
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
                10,
                10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000000000));

        int count = 0;
        while (true) {
            Thread.sleep(1000L);
            for (int i = 0; i < 9; i++) {
                executor.execute(() -> {
                    /*try {
                        Thread.sleep(1l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println("------------core:\t" + executor.getCorePoolSize() + "\tactive:\t" + executor.getActiveCount() + "\tmax:\t" + executor.getMaximumPoolSize());
                });
            }

            count++;
            if (count == 20) {
                executor.setCorePoolSize(5);
                executor.setMaximumPoolSize(20);
                System.out.println("----------------------------------------");
            }

            if (count == 100) {
                executor.shutdown();
                System.out.println("=============================================");
                break;
            }
        }

        Thread.currentThread().join();
    }
}
