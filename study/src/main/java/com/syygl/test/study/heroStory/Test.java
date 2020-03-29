package com.syygl.test.study.heroStory;

import com.syygl.test.study.heroStory.calculateHandler.CalHandlerFactory;
import com.syygl.test.study.heroStory.calculateHandler.ICalHandler;
import com.syygl.test.study.heroStory.processor.MainThreadProcessor;
import com.syygl.test.study.heroStory.util.Utils;
import com.syygl.test.study.heroStory.vipType.CommonType;
import com.syygl.test.study.heroStory.vipType.SilverType;
import com.syygl.test.study.heroStory.vipType.VIPType;

import java.util.concurrent.ExecutionException;

/**
 * Created by sunyy on 2020/3/28.
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * money和commonType是有客户端传进来的
         */

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            CommonType commonType = new CommonType();
            try {
                MainThreadProcessor.getInstance().processor(1000, commonType);

                //不交给主线程执行就是并发执行，如果操作的是同一份数据就要涉及到锁的概念
                //自己处理的方式如下
                ICalHandler<? extends VIPType> iCalHandler = CalHandlerFactory.create(commonType.getClass());
                iCalHandler.calculateMoney(1000, Utils.cast(commonType));


            } catch (Exception e) {
                System.out.println(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            SilverType silverType = new SilverType();
            try {
                MainThreadProcessor.getInstance().processor(1000, silverType);
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }

}


