package com.syygl.test.study.designPatterns.abstractFactory;

/**
 * Created by sunyy on 2020/2/5.
 */
public class RefelectCreatorImpl implements RefelectCreator {
    @Override
    public Product create(Class clazz) throws IllegalAccessException, InstantiationException {
        return (Product) clazz.newInstance();
    }
}
