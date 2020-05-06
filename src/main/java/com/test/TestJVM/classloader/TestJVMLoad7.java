package com.test.TestJVM.classloader;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 *
 **/

public class TestJVMLoad7 {
    public static void main(String[] args) throws ClassNotFoundException {
        //由bootstrap类加载器加载的类，它的类加载器打印为null
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        //由app类加载器加载的类，它的类加载器打印为sun.misc.Launcher$AppClassLoader
        Class<?> clazz2 = Class.forName("com.test.TestJVM.classloader.C");
        System.out.println(clazz2.getClassLoader());
    }

}

class C{
}


