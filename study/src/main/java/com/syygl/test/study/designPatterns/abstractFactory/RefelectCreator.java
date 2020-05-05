package com.syygl.test.study.designPatterns.abstractFactory;

/**
 * Created by sunyy on 2020/2/5.
 */
public interface RefelectCreator<T extends Product> {
    T create(Class<T> clazz) throws IllegalAccessException, InstantiationException;
}
