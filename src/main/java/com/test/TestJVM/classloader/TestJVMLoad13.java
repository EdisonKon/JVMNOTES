package com.test.TestJVM.classloader;

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

public class TestJVMLoad13 {
    public static void main(String[] args)  {

        /**
         * 输出：
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * sun.misc.Launcher$ExtClassLoader@63947c6b
         */

        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);
        while(loader.getParent()!=null){
            loader = loader.getParent();
            System.out.println(loader);
        }
//        Class<?> clazz = loader.loadClass("com.test.TestJVM.classloader.CL");
//        System.out.println(clazz);
//        System.out.println("--------------------");
//        clazz = Class.forName("com.test.TestJVM.classloader.CL");
//        System.out.println(clazz);
    }

}

