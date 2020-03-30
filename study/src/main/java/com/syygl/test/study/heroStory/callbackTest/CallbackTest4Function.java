package com.syygl.test.study.heroStory.callbackTest;

import com.syygl.test.study.heroStory.processor.Async4CallBackTest;
import com.syygl.test.study.heroStory.processor.IAsyncOperation;

import java.util.function.Function;

/**
 * Created by sunyy on 2020/3/30.
 */
public class CallbackTest4Function {
    public void callbackTest(String a, Function<String, String> callback) throws InterruptedException {
        //一大堆的逻辑处理以及调用

        IAsyncOperation asyncOperation = new AsyncTest4Function(callback);

        //这里才是真正异步执行
        Async4CallBackTest.getInstance().procesor(asyncOperation);

    }



    private class AsyncTest4Function implements IAsyncOperation {
        Function function ;

        public AsyncTest4Function(Function function) {
            this.function = function;
        }

        @Override
        public void doAsync() throws InterruptedException {
            Thread.sleep(1000);
            Object test = this.function.apply("test");

            System.out.println("callback success" + test.toString());
        }
    }
}
