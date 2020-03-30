package com.syygl.test.study.heroStory.processor;

/**
 * 异步操作接口
 */
public interface IAsyncOperation {
    /**
     * 获取绑定 Id
     *
     * @return 绑定 Id
     */
    default int getBindId() {
        return 0;
    }

    /**
     * 执行异步操作
     */
    void doAsync() throws InterruptedException;

    /**
     * 执行完成逻辑，具体实现中选择是否重写该方法
     */
    default void doFinish() {
    }
}
