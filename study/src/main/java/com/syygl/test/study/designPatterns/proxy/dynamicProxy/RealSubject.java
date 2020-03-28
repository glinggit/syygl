package com.syygl.test.study.designPatterns.proxy.dynamicProxy;

/**
 * Created by sunyy on 2020/2/6.
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething(String str) {
        System.out.println(str + "我是要被代理的啦");
    }
}
