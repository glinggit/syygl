package com.syygl.test.study.annotation;

import org.springframework.stereotype.Component;

/**
 * Created by sunyy on 2019/11/7.
 */
//将实例托管给spring容器
@Component
@NeedPrepareObject
public class TestClass {
    @NeedPrepareObject
    private String test1;
    @NeedPrepareObject
    private String test2;
    @NeedPrepareObject
    private String test3;

    private String test4;
}
