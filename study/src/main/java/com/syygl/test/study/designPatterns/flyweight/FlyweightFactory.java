package com.syygl.test.study.designPatterns.flyweight;

import java.util.HashMap;

/**
 * Created by sunyy on 2020/2/8.
 */
public class FlyweightFactory {
    //定义池容器
    private static HashMap<String, Flyweight> pool = new HashMap<String, Flyweight>();

    public static Flyweight getFlyweight(String extendState) {
        //需要返回的对象
        Flyweight flyweight = null;
        //获取对象
        if (pool.containsKey(extendState)) {
            flyweight = pool.get(extendState);
        } else {
            flyweight = new FlyweihtSon1(extendState);
            pool.put(extendState, flyweight);
        }
        return flyweight;
    }

}
