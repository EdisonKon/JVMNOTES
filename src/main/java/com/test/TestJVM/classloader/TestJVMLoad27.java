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
        Connection connection = DriverManager.getConnection("","","");

    }


}

