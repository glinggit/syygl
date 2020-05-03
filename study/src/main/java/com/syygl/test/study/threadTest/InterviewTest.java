package com.syygl.test.study.threadTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyy on 2020/5/1.
 * <p>
 * 一个线程往容器中加10个元素
 * 一个线程监控，加到5时，退出
 */
public class InterviewTest {
   volatile static List<String> list = new ArrayList<String>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add("test" + i);
            }
            System.out.println("I M OK");
        });

        Thread thread2 = new Thread(() -> {
            boolean flag = true;
            while (flag){
                if(list.size() == 5){
                    System.out.println("hahah   I look you ");
                    flag = false;
                }
            }
        });

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

    }
}
