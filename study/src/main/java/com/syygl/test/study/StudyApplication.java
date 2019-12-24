package com.syygl.test.study;

import com.syygl.test.study.springTest.SpecialBeanForEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    @Bean(initMethod = "start")
//    BenzCar benzCar(Engine engine) {
//        BenzCar car = new BenzCar();
//        car.engine = engine;
//        return car;
//    }

    @Bean
    SpecialBeanForEngine specialBeanForEngine() {
        return new SpecialBeanForEngine();
    }

}
