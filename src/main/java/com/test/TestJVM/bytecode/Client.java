package com.test.TestJVM.bytecode;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-15 13:46
 * @from
 **/
public class Client {
    public static void main(String[] args) {
        //是否保存生成的动态代理class文件
        //ProxyGenerator.class里的属性 - sun.misc.ProxyGenerator.saveGeneratedFiles
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        RealSubject rs = new RealSubject();
        InvocationHandler ih = new DynamicSubject(rs);
        Class<?> clazz = rs.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),ih);
        subject.reuqest();
        System.out.println(subject.toString());
        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
