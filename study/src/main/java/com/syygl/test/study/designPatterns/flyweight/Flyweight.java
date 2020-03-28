package com.syygl.test.study.designPatterns.flyweight;

import lombok.Getter;
import lombok.Setter;

/**
 * 如何建立多个可共享的的细粒度对象则是其关注的重点
 * Created by sunyy on 2020/2/8.
 */
@Getter
@Setter
public abstract class Flyweight {
    //内部状态
    private String innerState;

    //外部状态,必须接受一个外部状态
    protected final String extendState;
    public Flyweight(String extendState) {
        this.extendState = extendState;
    }

    public abstract void operation();
}
