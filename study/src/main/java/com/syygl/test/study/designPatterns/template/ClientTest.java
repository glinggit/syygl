package com.syygl.test.study.designPatterns.template;

/**
 * Created by sunyy on 2020/4/11.
 */
public class ClientTest {
    public static void main(String[] args) {
        Template method1 = new Method1(true);
        method1.templatemethod();
    }
}
