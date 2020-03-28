package com.syygl.test.study.designPatterns.proxy;

/**
 * Created by sunyy on 2020/2/6.
 */
public class ProxyObject implements SubjectObject {
    //要代理的实现类
    private SubjectObject subjectObject = null;

    //要代理的实现类
    private SubjectObject[] mulitSubjectObject = null;

    //代理一个
    public ProxyObject(SubjectObject subjectObject) {
        this.subjectObject = subjectObject;
    }
    //代理多个
    public ProxyObject(SubjectObject... subjectObject) {
        this.mulitSubjectObject = subjectObject;
    }

    @Override
    public void testProxy() {
        //代理前后做的事情
        this.doBefore();
        //被代理执行的方法
        this.subjectObject.testProxy();

        this.doAfter();
    }

    private void doBefore(){

    }

    private void doAfter(){

    }
}
