package com.syygl.test.study.designPatterns.proxy.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * Created by sunyy on 2020/2/6.
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();

        InvocationHandler invocationHandler = new MyInvocationHandler(subject);

        Subject proxyObject = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                new Class[]{Subject.class},
                invocationHandler);
        proxyObject.doSomething("hahaha");
    }
}
