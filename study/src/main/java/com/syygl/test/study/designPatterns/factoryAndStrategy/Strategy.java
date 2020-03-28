package com.syygl.test.study.designPatterns.factoryAndStrategy;

/**
 * Created by sunyy on 2020/1/27.
 */
public interface Strategy {
    // 计费方法
    double compute(long money);

    // 返回 type   优化的方法
    int getType();
}
