package com.syygl.test.study.annotation.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by sunyy on 2019/11/18.
 */
@Component
public class CommandLineRunnerTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //执行项目启动好后的初始化代码，这是springBoot的扩展点
        //使用 CommandLineRunner 对Spring Bean进行额外初始化
    }
}
