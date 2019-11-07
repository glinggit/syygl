package com.syygl.test.study.annotation;


import java.lang.annotation.*;

/**
 * Created by sunyy on 2019/11/7.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AspectAnnotationTest {
}
