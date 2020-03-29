package com.syygl.test.study.heroStory.calculateHandler;

import com.syygl.test.study.heroStory.vipType.VIPType;

/**
 * Created by sunyy on 2020/3/28.
 */
public interface ICalHandler<Vip extends VIPType> {
    long calculateMoney(long monry, Vip v);
}
