package com.syygl.test.study.heroStory.calculateHandler;

import com.syygl.test.study.heroStory.vipType.CommonType;

/**
 * Created by sunyy on 2020/3/28.
 */
public class CommonCalHandler implements ICalHandler<CommonType> {
    @Override
    public long calculateMoney(long monry, CommonType v) {
        return 1000;
    }
}
