package com.syygl.test.study.heroStory.callbackTest;

import com.syygl.test.study.heroStory.processor.Async4CallBackTest;
import com.syygl.test.study.heroStory.processor.IAsyncOperation;

/**
 * Created by sunyy on 2020/3/30.
 */
public class CallbackTest {
    public void callbackTest(String a, SendCallback sendCallback) throws InterruptedException {
        //一大堆的逻辑处理以及调用

        //可以将下面这段很耗时的逻辑放到异步线程中去

        IAsyncOperation asyncOperation = new AsyncTest(sendCallback);

        //这里才是真正异步执行
        Async4CallBackTest.getInstance().procesor(asyncOperation);

    }


    private class AsyncTest implements IAsyncOperation {

        private SendCallback sendCallback;

        public AsyncTest(SendCallback sendCallback) {
            this.sendCallback = sendCallback;
        }

        @Override
        public void doAsync() throws InterruptedException {
            Thread.sleep(1000);
            sendCallback.onSuccess("hahahah,nizhenniu");
        }
    }
}
