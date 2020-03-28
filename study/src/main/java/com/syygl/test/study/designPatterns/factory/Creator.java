package com.syygl.test.study.designPatterns.factory;

/**
 * Created by sunyy on 2020/2/5.
 */
public interface Creator {
    //<T extends Product> 定义了泛型，必须是Product的实现类

    public <T extends Product> T createProduct(Class<T> c);
}
