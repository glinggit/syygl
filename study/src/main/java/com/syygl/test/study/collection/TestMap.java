package com.syygl.test.study.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunyy on 2020/5/9.
 */
public class TestMap {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("1", "2");

        //装饰模式
        Collections.synchronizedMap(map);
    }
}
