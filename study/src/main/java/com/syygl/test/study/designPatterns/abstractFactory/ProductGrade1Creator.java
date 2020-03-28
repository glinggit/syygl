package com.syygl.test.study.designPatterns.abstractFactory;

/**
 * Created by sunyy on 2020/2/5.
 */
public class ProductGrade1Creator implements Creator {
    @Override
    public ProductA createProductA() {
        System.out.println("等级1的A产品");
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        System.out.println("等级1的B产品");
        return new ConcreteProductB1();
    }
}
