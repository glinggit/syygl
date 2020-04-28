package com.syygl.test.study.springTest;

/**
 * Created by sunyy on 2020/4/5.
 */
public class StudyTest {
    public static void main(String[] args) {
        //退出程序时的钩子函数
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("exit");
        }));
    }
}
