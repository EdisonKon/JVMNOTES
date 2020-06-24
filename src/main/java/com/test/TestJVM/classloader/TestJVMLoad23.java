package com.test.TestJVM.classloader;

//import sun.misc.Launcher;

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

public class TestJVMLoad23 {
    public static void main(String[] args)  {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));


        System.out.println(ClassLoader.class.getClassLoader());

//        System.out.println(Launcher.class.getClassLoader());

        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(ClassLoader.getSystemClassLoader());


    }

}

