package com.syygl.test.study.designPatterns.factory;

/**
 * Created by sunyy on 2020/2/5.
 */
public class ConcreteCreator implements Creator {
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) product;
    }
}
