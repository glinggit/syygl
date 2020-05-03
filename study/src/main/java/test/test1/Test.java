package test.test1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by sunyy on 2020/4/22.
 */

/**
 * @ConfigurationProperties  与  @EnableAutoConfiguration  的结合使用  + spring.factories
 *
 */
//配置文件里对应的配置对象
public class Test {
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
