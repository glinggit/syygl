package com.syygl.test.study.designPatterns.template;

/**
 * Created by sunyy on 2020/2/5.
 */
public class Method1 extends Template {
    private boolean isHook;

    public Method1(boolean isHook) {
        this.isHook = isHook;
    }

    public Method1(){}

    @Override
    protected void doSomething() {
        System.out.println("11111");
    }

    @Override
    protected void doSomething2() {
        System.out.println("2222222");
    }

    @Override
    protected boolean isHook() {
        return this.isHook;
    }

}
