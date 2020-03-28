package com.syygl.test.study.designPatterns.singleton;

/**
 * Created by sunyy on 2020/2/5.
 */
public class Client {
    public static void main(String[] args) {
        Singleton.getInstance().sayHello();
    }
}
