/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.syygl.test.study.annotation.core;

import com.syygl.test.study.annotation.NeedPrepareObject;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

/**
 * spring中bean 的多例与单例，默认都是单例
 * 在springBoot项目中如果要配置单例或者多例，可以在对应的bean上加一个@scope()注解
 * <bean id="hi" class="com.validationTest.Hi" init-method="init" scope="singleton">
 * singleton 单例
 * prototype多例
 * <p>
 * 先获取被NeedPrepareObject注解标识的类，再获取类中被标识了的成员变量
 * <p>
 * 实现该接口后，当所有单例 bean 都初始化完成以后， 容器会回调该接口的方法 afterSingletonsInstantiated。
 * 主要应用场合就是在所有单例 bean 创建完成之后，可以在该回调中做一些事情。
 */
@Configuration
public class NeedPrepareObjectConfiguration implements ApplicationContextAware, SmartInitializingSingleton {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    @Override
    public void afterSingletonsInstantiated() {
        //获取指定类型的bean存在局限性
        Map<String, Object> beans = this.applicationContext.getBeansWithAnnotation(NeedPrepareObject.class);
        if (Objects.nonNull(beans)) {
            beans.forEach(this::registerContainer);
        }
        //获取所有的class类
        ConfigurableListableBeanFactory beanFactory = this.applicationContext.getBeanFactory();
        if (beanFactory instanceof DefaultListableBeanFactory) {
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
            for (String name : defaultListableBeanFactory.getBeanDefinitionNames()) {
                BeanDefinition beanDefinition = defaultListableBeanFactory.getBeanDefinition(name);
                if (beanDefinition instanceof RootBeanDefinition) {
                    RootBeanDefinition rootBeanDefinition = (RootBeanDefinition) beanDefinition;
                    //processBeanClass(rootBeanDefinition.getTargetType(), name);
                }
            }
        }
        //获取所有Bean的名称
        String[] beanDefinitionNames = this.applicationContext.getBeanDefinitionNames();
    }

    private void registerContainer(String beanName, Object bean) {
        Class<?> clazz = AopProxyUtils.ultimateTargetClass(bean);
        //获取类的所有声明字段
        Field[] declaredFields = clazz.getDeclaredFields();

        for (int i = 0; i < declaredFields.length; i++) {
            //获取声明字段上的NeedPrepareObject注解
            NeedPrepareObject annotation = declaredFields[i].getAnnotation(NeedPrepareObject.class);
            if (null != annotation) {
                System.out.println(beanName + "::::::" + declaredFields[i].getName());
            }

        }
    }


}
