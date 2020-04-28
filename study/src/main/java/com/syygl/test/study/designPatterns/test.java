package com.syygl.test.study.designPatterns;

import java.util.*;

/**
 * Created by sunyy on 2020/2/5.
 */
public class test {
    public static void main(String[] args) {

        Map map = new HashMap();
        map = Collections.synchronizedMap(map);
        List list = new ArrayList();
        list = (List)Collections.synchronizedCollection(list);
    }
}
