package com.syygl.test.study.generic;

import java.util.Date;

/**
 * Created by sunyy on 2019/12/18.
 */
public class GenericIntImpl2 implements GenericInt2<Date> {
    @Override
    public <K> String exec(Date date, K k) {
        return null;
    }
//    @Override
//    public String exec(Date o) {
//        return null;
//    }
}
