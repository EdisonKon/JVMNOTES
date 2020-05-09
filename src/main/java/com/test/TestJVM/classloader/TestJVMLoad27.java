package com.test.TestJVM.classloader;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
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
 * https://www.bilibili.com/video/BV1qE411Y7FQ?p=31
 *
 **/

public class TestJVMLoad27 {

    public static void main(String[] args)  throws Exception{

        /**
         * Class.forName("com.mysql.jdbc.Driver")会使com.mysql.jdbc.Driver里的所有静态代码块被初始化
         * 且该Driver类里的其他调用类的静态代码块都会被初始化 例如java.sql.DriverManager
         *
         */
        Class.forName("com.mysql.jdbc.Driver");
        /**
         * 在DriverManager中，getConnection会进行Class.forName()进行主动使用SPI的实现类，这时候因为DriverManager是由
         * BootstrapClassloader进行加载的，所以按照双亲委托机制，spi的实现类也应该由boot进行加载，但是boot它加载不了，所以
         * DriverManager会找不到spi实现类，双亲委托不可行。
         * 此时上下文加载器起作用，getConnection里由一个Reflection.getCallerClass()这个参数，获取调用该方法的类，以便于获取该类的加载器，也就是
         * 上下文加载器（此处为appclassloader，然后是由appcl进行加载，使用 Class.forName(driver.getClass().getName(), true, classLoader)方法
         * 进行加载，所以SPI的实现类可以成功被加载
         */
        Connection connection = DriverManager.getConnection("","","");

    }


}

