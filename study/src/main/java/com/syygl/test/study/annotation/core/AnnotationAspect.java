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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.syygl.test.study.annotation.core;

import com.syygl.test.study.annotation.AspectAnnotationTest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * 拦截器方式使用自定义注解
 */

@Aspect
@Service
public class AnnotationAspect {

    public AnnotationAspect() {
    }

    @Pointcut("execution(* com.syygl.test.study.service..*(..))")
    public void mQAdminMethodPointCut() {

    }

    @Pointcut("@annotation(com.syygl.test.study.annotation.AspectAnnotationTest)")
    public void multiMQAdminMethodPointCut() {

    }

    @Around(value = "mQAdminMethodPointCut() || multiMQAdminMethodPointCut()")
    public Object aroundMQAdminMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = null;
        try {
            MethodSignature signature = (MethodSignature)joinPoint.getSignature();
            Method method = signature.getMethod();
            AspectAnnotationTest multiMQAdminCmdMethod = method.getAnnotation(AspectAnnotationTest.class);
//            if (multiMQAdminCmdMethod != null && multiMQAdminCmdMethod.timeoutMillis() > 0) {
//                MQAdminInstance.initMQAdminInstance(multiMQAdminCmdMethod.timeoutMillis());
//            }
//            else {
//                MQAdminInstance.initMQAdminInstance(0);
//            }
            obj = joinPoint.proceed();
        }
        finally {
//            MQAdminInstance.destroyMQAdminInstance();
        }
        return obj;
    }
}