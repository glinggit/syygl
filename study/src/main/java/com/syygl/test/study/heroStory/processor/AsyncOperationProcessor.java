package com.syygl.test.study.heroStory.processor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步执行线程
 * Created by sunyy on 2020/3/29.
 */
public class AsyncOperationProcessor {
    /**
     * 单例对象
     */
    static private final AsyncOperationProcessor _instance = new AsyncOperationProcessor();

    /**
     * 线程数组
     */
    private final ExecutorService[] _esArray = new ExecutorService[8];

    /**
     * 私有化类默认构造器
     */
    private AsyncOperationProcessor() {
        for (int i = 0; i < _esArray.length; i++) {
            // 线程名称
            final String threadName = "AsyncOperationProcessor_" + i;
            // 创建单线程服务
            _esArray[i] = Executors.newSingleThreadExecutor(new ThreadFactoryImpl("syygl1027Async"));
        }
    }

    /**
     * 获取单例对象
     *
     * @return 异步操作处理器
     */
    static public AsyncOperationProcessor getInstance() {
        return _instance;
    }


    /**
     * 处理器异步操纵
     *
     * @param asyncOp 异步操纵
     */
    public void process(IAsyncOperation asyncOp) {
        // 根据绑定 Id 获取线程索引
        int bindId = Math.abs(asyncOp.getBindId());
        int esIndex = bindId % _esArray.length;

        _esArray[esIndex].submit(() -> {
            // 执行异步操纵
            asyncOp.doAsync();

            // 回到主消息处理器执行完成逻辑
            MainThreadProcessor.getInstance().process(asyncOp::doFinish);
        });
    }


}
