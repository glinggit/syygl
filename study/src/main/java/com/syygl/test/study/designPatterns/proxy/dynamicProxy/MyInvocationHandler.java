package com.syygl.test.study.designPatterns.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sunyy on 2020/2/6.
 */
public class MyInvocationHandler implements InvocationHandler {
    //被代理的对象
    private Object target = null;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    //代理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前签合同");
        Object result = method.invoke(this.target, args);
        System.out.println("代理后交钱");
        return result;
    }
}
