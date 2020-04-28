package com.syygl.test.study.javaassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.Method;

/**
 * Created by sunyy on 2020/3/30.
 */
public class DemoTest {
    public static void main(String[] args) throws Exception {
        DemoTest demoTest = new DemoTest();
        demoTest.test1();
        demoTest.test2();
    }

    //动态生成一个全新的类
    public void test1() throws Exception {
        // ClassPool包含所有动态生成的类，getDefault()返回默认的ClassPool，
        ClassPool cp = ClassPool.getDefault();
        // 动态生成一个类
        CtClass gclazz = cp.makeClass("org.jamee.demo.javaassist.GeneratedClass");
        CtMethod gmethod = CtMethod
                .make("public void sayHello() { System.out.println(\"Hello Javaassist\"); }", gclazz);
        gclazz.addMethod(gmethod);
        // 转换成Class
        Class<?> gc = gclazz.toClass();
        // 将该CtClass从ClassPool中移除，
        gclazz.detach();
        // 调用方法
        Object ginst = gc.newInstance();
        Method gm = gc.getMethod("sayHello");
        gm.invoke(ginst);
    }

    public void test2() throws Exception {
        // ClassPool包含所有动态生成的类，getDefault()返回默认的ClassPool，
        ClassPool cp = ClassPool.getDefault();
        // 该ClassPool默认从java lib，ext，classpath搜索class文件，并生成一个CtClass返回
        CtClass clazz = cp.get("com.syygl.test.study.javaassist.TestClass");
        // 修改compute方法
        CtMethod method = clazz.getDeclaredMethod("compute");
        // $args，参数（$1，第一个参数，$2，$3以此类推) ，$_：返回值
        method.insertAfter("System.out.println(\"compute called with param: \" + java.util.Arrays.toString($args) + \", return: \" + $_);");
        // 转换成Class，这一步也载入了修改后的Class。注意：必须保证之前这个Class没有载入过，不然会报异常：java.lang.LinkageError，因为JVM不允许一个class多次加载
        clazz.toClass();
        // 将该CtClass从ClassPool中移除，
        clazz.detach();


        clazz.writeFile("C:/Data/Temp+Test/debug-java");

        // 这时载入的TestClass已经被修改
        TestClass test = new TestClass();
        // 调用方法
        test.compute(5);
    }


//    public void test3() throws IllegalAccessException, InstantiationException {
//        ProxyFactory factory = new ProxyFactory();
//        // 设置父类，ProxyFactory将会动态生成一个类，继承该父类
//        factory.setSuperclass(TestClass.class);
//        // 设置过滤器，判断哪些方法调用需要被拦截
//        factory.setFilter(new MethodFilter() {
//            public boolean isHandled(Method m) {
//                if (m.getName().equals("compute")) {
//                    return true;
//                }
//                return false;
//            }
//        });
//        Class<?> c = factory.createClass();
//        TestClass object = (TestClass) c.newInstance();
//        // 设置拦截处理
//        ((Proxy) object).setHandler(new MethodHandler() {
//            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
//                long start = System.currentTimeMillis();
//                try {
//                    return proceed.invoke(self, args);
//                } catch (Exception e) {
//                    throw e;
//                } finally {
//                    long taken = System.currentTimeMillis() - start;
//                    System.out.println("call method: " + thisMethod.getName() + " take: " + taken + "ms");
//                }
//            }
//        });
//
//        // 调用方法
//        System.out.println(object.compute(11));
//    }


}

class TestClass {
    public int compute(int param) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return param + 100;
    }
}
