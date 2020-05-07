package com.test.TestJVM.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 *  调用classloader的加载方法并不是对类的主动使用，不会触发初始化
 *
 *  Class.forName 反射是主动使用，会触发初始化
 *
 **/

public class TestJVMLoad14 {
    public static void main(String[] args) throws IOException {

        /**
         * 输出：
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * file:/Users/edison/github/JVMNOTES/target/classes/com/test/TestJVM/classloader/TestJVMLoad14.class
         */

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);

        String resourceName = "com/test/TestJVM/classloader/TestJVMLoad14.class";

        Enumeration<URL> urls = loader.getResources(resourceName);

        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("------------------");

        Class<?> clazz = TestJVMLoad14.class;
        System.out.println(clazz.getClassLoader());

        System.out.println("------------------");

        Class<?> clazz2 = String.class;
        System.out.println(clazz2.getClassLoader());
    }

}

