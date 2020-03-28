package com.syygl.test.study.designPatterns.singleton;

/**
 * Created by sunyy on 2020/2/5.
 */
public class Singleton {
    //私有的构造方法，外部无法使用new创建对象
    private Singleton() {
    }
    //饿汉模式
    private static final Singleton singleton = new Singleton();

    //供外部获取该实例
    public static Singleton getInstance(){
        return singleton;
    }

    //类中其他的方法
    public void sayHello(){
        System.out.println("say hello");
    }
}
