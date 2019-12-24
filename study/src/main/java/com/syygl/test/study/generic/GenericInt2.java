package com.syygl.test.study.generic;

/**
 * Created by sunyy on 2019/12/18.
 */
//泛型接口    泛型方法
public interface GenericInt2<T> {
    public <K> String exec(T t, K k);
}
