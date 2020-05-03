package test.test1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created by sunyy on 2020/4/30.
 */
//初始化的标记，要么用注解（需要注意扫描路径），要么放到spring.factories文件中，
public class Test4AutoConfig {
    @Bean
    public Test4NewBean createTest() {
        return new Test4NewBean();
    }
}


//自己封装的jar包如何使用springboot的autoConfiguration
/**
 * 1.写配置文件properties或yml
 * 2.根据配置文件定义自己的Bean
 * 3.对自己的Bena封装下，放到带有@ConfigurationProperties注解的Bean中去
 * 4.通过@Bean初始化第三步的Bean
 * 5.第四步的操作放到@EnableAutoConfiguration或spring.factories中去
 */
