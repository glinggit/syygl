package com.syygl.test.study.designPatterns.proxy.dynamicProxy;


import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * Created by sunyy on 2020/2/6.
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");

        InvocationHandler invocationHandler = new MyInvocationHandler(subject);

        Subject proxyObject = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                new Class[]{Subject.class},
                invocationHandler);
        proxyObject.doSomething("hahaha");



        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback((Callback) new MyMethodInterceptor());
        // 创建代理对象
        HelloService proxy= (HelloService)enhancer.create();
        // 通过代理对象调用目标方法
        proxy.sayHello();

    }
}
