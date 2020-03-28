package com.syygl.test.study.designPatterns.proxy;

/**
 * Created by sunyy on 2020/2/6.
 */
public class RealObject implements SubjectObject {
    @Override
    public void testProxy() {
        System.out.println("我是要被代理的哦");
    }
}
