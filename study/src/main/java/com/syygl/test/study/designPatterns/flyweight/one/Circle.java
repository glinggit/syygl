package com.syygl.test.study.designPatterns.flyweight.one;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by sunyy on 2020/2/8.
 */
@Getter
@Setter
@RequiredArgsConstructor
public class Circle implements Shape {
    @NonNull
    private String color;
    private int x;
    private int y;
    private int radius;

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                + ", x : " + x + ", y :" + y + ", radius :" + radius);
    }
}
