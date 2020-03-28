package com.syygl.test.study.designPatterns.factoryAndStrategy;

/**
 * Created by sunyy on 2020/1/27.
 */
// 普通会员策略
public class OrdinaryStrategy implements Strategy {

    @Override
    public double compute(long money) {
        System.out.println("普通会员 不打折");
        return money;
    }

    @Override
    public int getType() {
        return 1;
    }
}
