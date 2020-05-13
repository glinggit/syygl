package com.syygl.test.study.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by sunyy on 2020/5/10.
 */
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(50);

        Object lock = new Object();

        for (int i = 0; i < 50; i++) {
            executorService.execute(() -> {
                synchronized (lock){
                    lock.notifyAll();
                    System.out.println("haha");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        }


        for (;;){
            Thread.sleep(100000);
        }



    }


}
