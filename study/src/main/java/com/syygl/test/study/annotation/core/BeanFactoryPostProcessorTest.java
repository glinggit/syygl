package com.syygl.test.study.annotation.core;

import com.syygl.test.study.annotation.NeedPrepareObject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * BeanFactoryPostProcessor是用来处理修改bean定义信息的后置处理器，
 * 这个时候bean还没有初始化，只是定好了BeanDefinition，在BeanFactoryPostProcessor接口的postProcessBeanFactory方法中，
 * 我们可以修改bean的定义信息，例如修改属性的值，修改bean的scope为单例或者多例。
 *
 * BeanPostProcessor则是bean初始化前后对bean的一些操作，意思就是说bean在调用构造之后，初始化方法前后进行一些操作。
 */
@Component
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {
    /**
     * 这个是所有的bean的定义信息定义好之后，初始化前的最后一次提供修改的操作，
     * 这里一般都是用来修改bean的定义信息或者修改bean的属性用的，
     * 这个接口没有提供默认的实现方法，它是一个void方法
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (beanFactory instanceof DefaultListableBeanFactory) {
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
            for (String name : defaultListableBeanFactory.getBeanDefinitionNames()) {
                BeanDefinition beanDefinition = defaultListableBeanFactory.getBeanDefinition(name);
                if (beanDefinition instanceof RootBeanDefinition) {
                    RootBeanDefinition rootBeanDefinition = (RootBeanDefinition) beanDefinition;
                    processBeanClass(rootBeanDefinition.getTargetType(), name);
                }
            }
        }
    }

    private void processBeanClass(Class<?> clazz, String beanName) {
        Method[] methods = clazz.getMethods();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Method method : methods) {
            //获取含有特定注解的方法
            method.getAnnotation(NeedPrepareObject.class);
        }
        for (Field field : declaredFields) {
            //获取含有特定注解的成员变量
            field.getAnnotation(NeedPrepareObject.class);
        }
    }
}
