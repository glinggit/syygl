package com.syygl.test.study.heroStory.processor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sunyy on 2020/3/30.
 * 测试异步完成，但不需要回到主线程的例子
 */
public class Async4CallBackTest {
    ExecutorService es = Executors.newSingleThreadExecutor(new ThreadFactoryImpl("test"));

    private Async4CallBackTest(){}

    private static Async4CallBackTest async4CallBackTest = new Async4CallBackTest();

    public static Async4CallBackTest getInstance(){
        return async4CallBackTest;
    }

    public void procesor(IAsyncOperation asyncOperation){
        es.submit(() -> {
            try {
                asyncOperation.doAsync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
