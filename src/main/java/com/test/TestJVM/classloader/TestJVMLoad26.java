package com.test.TestJVM.classloader;


import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;


/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 *  当前类加载器（current classloader）
 *  每个类都会使用当前类加载器（加载自己的类加载器）尝试去加载它所依赖的其他的类
 *
 * 线程上下文类加载器一般使用模式 （获取 - 使用 - 还原）
 *
 *
 **/

public class TestJVMLoad26 {

    public static void main(String[] args)  throws Exception{
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while(iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println("driver"+driver.getClass()+"loader:"+driver.getClass().getClassLoader());
        }

        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ServiceLoader.class.getClassLoader());
    }


}

