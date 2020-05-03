package com.syygl.test.study.annotation.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import test.test1.Test;
import test.test1.Test4NewBean;

/**
 * Created by sunyy on 2020/4/30.
 */
@Component
public class Test4Config implements CommandLineRunner{
   //项目中通过注入的形式使用该对象
    @Autowired
    Test4NewBean test4NewBean;
    @Override
    public void run(String... args) throws Exception {
        System.err.println(test4NewBean.getTest().getTest());
    }
}
