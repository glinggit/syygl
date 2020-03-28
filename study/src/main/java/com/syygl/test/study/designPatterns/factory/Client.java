package com.syygl.test.study.designPatterns.factory;

/**
 * Created by sunyy on 2020/2/5.
 */
public class Client {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.createProduct(ConcreteProduct1.class);
    }
}
