package com.zhh.java.jvm;

import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("/Users/cechealth/gitrepo/java-demo/src/main/java/com/zhh/java/jvm/");
        Class<?> exampleClass = myClassLoader.loadClass("Example");

        System.out.println("加载此类的类加载器：" + exampleClass.getClassLoader().getClass().getName());
        System.out.println("父类加载器：" + exampleClass.getClassLoader().getParent().getClass().getName());

        Object instance = exampleClass.newInstance();
        Method method = exampleClass.getMethod("print");
        method.invoke(instance);
    }
}
