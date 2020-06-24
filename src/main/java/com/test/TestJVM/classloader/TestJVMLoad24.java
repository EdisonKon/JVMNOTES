package com.test.TestJVM.classloader;


/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 *  当前类加载器（current classloader）
 *  每个类都会使用当前类加载器（加载自己的类加载器）尝试去加载它所依赖的其他的类
 *
 * 线程上下文类加载器是从jdk1.2引入的
 * Thread的.getContextClassLoader()和setContextClassLoader()可用来获取和设置
 * 如果没有设置，则该线程上下文类加载器就是父线程上下文类加载器
 * java启动时候运行的线程就是appclassloader
 **/

public class TestJVMLoad24 {
    public static void main(String[] args)  throws Exception{
        TestJVMLoad16 t1 = new TestJVMLoad16("load1");
        t1.setPath("J:\\");
        Thread.currentThread().setContextClassLoader(t1);
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println("-------------------------");
        System.out.println(Thread.class.getClassLoader());
        System.out.println("-------------------------");
        Class c1 = t1.loadClass("com.test.TestJVM.classloader.Parent");
        System.out.println(c1.getClassLoader());
        MyParent1 parent1 = new MyChild1();

    }

}

