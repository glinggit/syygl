package com.syygl.test.study.heroStory.callbackTest;

import java.util.function.Function;

/**
 * Created by sunyy on 2020/3/30.
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        CallbackTest callbackTest = new CallbackTest();
        callbackTest.callbackTest("test", new SendCallback() {
            @Override
            public void onSuccess(String sendResult) {
                System.out.println("thread name" + Thread.currentThread().getName());
                System.out.println(sendResult);
            }

            @Override
            public void onException(Throwable e) {

            }
        });
        System.out.println("qqq");


        //*******************************************************************************
        CallbackTest4Function callbackTest4Function = new CallbackTest4Function();
        //这里的new Function接口其实和自定义的SendCallback一样的道理
        callbackTest4Function.callbackTest("a", new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println("s==" + s);
                return "是你调用了我么？";
            }
        });


    }
}
