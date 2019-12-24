package com.syygl.test.study.testGetMethod;

/**
 * Created by sunyy on 2019/11/27.
 */
public class TestBean {
    private String test1 = "hahahah";
    private String test2;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        if(null == test2){
            this.test2 = InvokeMethod.getStringM(this);
        }
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}
