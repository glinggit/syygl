package com.syygl.test.study.lombokTest;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by sunyy on 2019/12/11.
 */
@Data
@Setter
@Getter
@RequiredArgsConstructor(staticName = "of")
public class LombokTest {
    private String name;
    private String age;
}
