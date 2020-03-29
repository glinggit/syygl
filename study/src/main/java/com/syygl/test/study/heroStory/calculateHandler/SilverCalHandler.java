package com.syygl.test.study.heroStory.calculateHandler;

import com.syygl.test.study.heroStory.vipType.CommonType;

/**
 * Created by sunyy on 2020/3/28.
 */
public class SilverCalHandler implements ICalHandler<CommonType> {
    @Override
    public long calculateMoney(long monry, CommonType v) {
        return 100;
    }
}
