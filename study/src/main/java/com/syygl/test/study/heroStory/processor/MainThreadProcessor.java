package com.syygl.test.study.heroStory.processor;

import com.syygl.test.study.heroStory.util.Utils;
import com.syygl.test.study.heroStory.calculateHandler.CalHandlerFactory;
import com.syygl.test.study.heroStory.calculateHandler.ICalHandler;
import com.syygl.test.study.heroStory.vipType.VIPType;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sunyy on 2020/3/28.
 */
public class MainThreadProcessor {

    /**
     * 单例对象
     */
    static private final MainThreadProcessor _instance = new MainThreadProcessor();

    /**
     * 私有化类默认构造器
     */
    private MainThreadProcessor() {
    }

    /**
     * 获取单例对象
     *
     * @return 单例对象
     */
    static public MainThreadProcessor getInstance() {
        return _instance;
    }

    ExecutorService es = Executors.newSingleThreadExecutor(new ThreadFactoryImpl("syygl1027"));


    public void processor(long mony, VIPType vipType) throws ExecutionException, InterruptedException {
        //空值校验

        Class<?> clazz = vipType.getClass();

        es.submit(() -> {

            System.out.println(Thread.currentThread().getName());

            ICalHandler<? extends VIPType> calHandler = CalHandlerFactory.create(clazz);

            //这里的vipType需要借助于一个消息转型
            calHandler.calculateMoney(mony, Utils.cast(vipType));

        });

    }

    public void process(Runnable r) {
        if (null != r) {
            es.submit(r);
        }
    }
}
