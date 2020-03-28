package com.syygl.test.study.designPatterns.factoryAndStrategy;

/**
 * Created by sunyy on 2020/1/27.
 */
// 白银会员策略
public class SilverStrategy implements Strategy {

    @Override
    public double compute(long money) {
        System.out.println("白银会员 优惠50元");
        return money - 50;
    }

    @Override
    public int getType() {
        return 2;
    }
}
