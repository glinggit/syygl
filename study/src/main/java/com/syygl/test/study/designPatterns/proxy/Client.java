package com.syygl.test.study.designPatterns.proxy;

/**
 * Created by sunyy on 2020/2/6.
 */
public class Client {
    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        ProxyObject proxyObject = new ProxyObject(realObject, realObject);
        proxyObject.testProxy();
    }
}
