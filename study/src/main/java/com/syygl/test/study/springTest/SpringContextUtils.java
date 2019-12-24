package com.syygl.test.study.springTest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by sunyy on 2019/11/18.
 */
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContextUtils.applicationContext == null) {
            SpringContextUtils.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }


}
