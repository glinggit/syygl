package com.syygl.test.study.annotation.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by sunyy on 2019/11/18.
 */
@Component
@Order(10)
public class CommandLineRunnerTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Arrays.asList(args).forEach(s ->{
            System.out.println(s);
        });
        System.out.println(10);
    }
}

@Component
@Order(10)
class CommandLineRunnerTest3 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(10 + "1");
        //执行项目启动好后的初始化代码，这是springBoot的扩展点
        //使用 CommandLineRunner 对Spring Bean进行额外初始化
    }
}


@Component
@Order(9)
class CommandLineRunnerTest1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(9);
        //执行项目启动好后的初始化代码，这是springBoot的扩展点
        //使用 CommandLineRunner 对Spring Bean进行额外初始化
    }
}


@Component
@Order(8)
class CommandLineRunnerTest2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(8);
        //执行项目启动好后的初始化代码，这是springBoot的扩展点
        //使用 CommandLineRunner 对Spring Bean进行额外初始化
    }
}
