package com.syygl.test.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StudyApplication.class, args);
    }

}
