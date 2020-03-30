package com.syygl.test.study.heroStory.callbackTest;

public interface SendCallback {
    void onSuccess(final String sendResult);

    void onException(final Throwable e);

    default void test(){}
}