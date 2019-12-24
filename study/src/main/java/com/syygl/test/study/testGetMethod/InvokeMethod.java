package com.syygl.test.study.testGetMethod;

/**
 * Created by sunyy on 2019/11/27.
 */
public class InvokeMethod {
    public static String getStringM(Object bean){
        TestBean testBean = (TestBean)bean;
        System.out.println(testBean.getTest1());
        System.out.println("1111111111111111");
        return "222222";
    }
}
