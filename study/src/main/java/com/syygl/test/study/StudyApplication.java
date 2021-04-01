package com.syygl.test.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.math.MathContext;

@SpringBootApplication
public class StudyApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StudyApplication.class, args);


        BigDecimal bigDecimal = new BigDecimal("1000");



    }

}
