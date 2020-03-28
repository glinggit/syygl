package com.syygl.test.study.designPatterns.singleton;

/**
 * Created by sunyy on 2020/2/23.
 */
public class Singleton2 {
    //让外部new不了
    private Singleton2() {
    }

    //静态内部类实现单例模式
    public static class Holder {
        private static Singleton2 singleton2 = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return Holder.singleton2;
    }
}
