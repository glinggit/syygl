package com.syygl.test.study.designPatterns.template;

/**
 * Created by sunyy on 2020/2/5.
 */
public abstract class Template {
    protected abstract void doSomething();

    protected abstract void doSomething2();

    //final方法是抽象类的灵魂,子类无法修改
    public final void templatemethod() {
        //定义完成一组算法
        if(this.isHook()){

        }
        //todo
    }

    //钩子方法，将不确定性的东西留给具体的实现
    //由子类的返回值决定模板方法中的逻辑
    protected boolean isHook() {
        return false;
    }
}
