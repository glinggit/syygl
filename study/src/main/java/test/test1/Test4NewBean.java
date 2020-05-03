package test.test1;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by sunyy on 2020/4/30.
 */
@ConfigurationProperties(prefix = "syy")
public class Test4NewBean {
    //将配置文件里的对象获取过来，如果是列表形式的就用List
    Test test;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
