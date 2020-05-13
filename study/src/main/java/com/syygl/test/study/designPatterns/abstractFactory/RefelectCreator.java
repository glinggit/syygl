package com.syygl.test.study.designPatterns.abstractFactory;

/**
 * Created by sunyy on 2020/2/5.
 */

/**
 * Product作为总接口没有具体实现，T为具体的各个产品的抽象
 * @param <T>
 */
public interface RefelectCreator<T extends Product> {
    T create(Class<T> clazz) throws IllegalAccessException, InstantiationException;
}
