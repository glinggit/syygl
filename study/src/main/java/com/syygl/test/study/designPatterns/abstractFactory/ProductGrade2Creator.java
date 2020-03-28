package com.syygl.test.study.designPatterns.abstractFactory;

/**
 * Created by sunyy on 2020/2/5.
 */
public class ProductGrade2Creator implements Creator {
    @Override
    public ProductA createProductA() {
        System.out.println("等级2的A产品");
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        System.out.println("等级2的B产品");
        return new ConcreteProductB2();
    }
}
