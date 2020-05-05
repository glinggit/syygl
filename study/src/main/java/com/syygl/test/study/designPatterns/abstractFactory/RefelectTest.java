package com.syygl.test.study.designPatterns.abstractFactory;

/**
 * Created by sunyy on 2020/5/5.
 */
public class RefelectTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        RefelectCreator refelectCreator = new RefelectCreatorImpl();
        ConcreteProductA1 product = (ConcreteProductA1) refelectCreator.create(ConcreteProductA1.class);
        product.doSomethingA();


    }
}
