package com.syygl.test.study.heroStory.calculateHandler;

import com.syygl.test.study.heroStory.vipType.CommonType;
import com.syygl.test.study.heroStory.vipType.SilverType;
import com.syygl.test.study.heroStory.vipType.VIPType;

/**
 * Created by sunyy on 2020/3/28.
 */
public final class CalHandlerFactory {
    //私有构造方法
    private CalHandlerFactory() {
    }

    private static CalHandlerFactory calHandlerFactory = new CalHandlerFactory();

    public static ICalHandler<? extends VIPType> create(Class<?> vipClass) {
        /*
           工厂模式的使用，这里还可以进一步优化
         */
        if (vipClass == CommonType.class) {
            return new CommonCalHandler();
        }
        if (vipClass == SilverType.class) {
            return new SilverCalHandler();
        }
        return null;
    }
}
