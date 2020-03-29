package com.syygl.test.study.heroStory.util;

import com.syygl.test.study.heroStory.vipType.VIPType;

/**
 * Created by sunyy on 2020/3/28.
 */
public class Utils {
    public static <VipType extends VIPType> VipType cast(Object obj) {
        /*
        将obj强转为VipType
         */
        return (VipType) obj;
    }
}
