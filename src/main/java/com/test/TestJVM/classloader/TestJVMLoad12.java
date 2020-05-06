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

public class TestJVMLoad12 {
    public static void main(String[] args) throws ClassNotFoundException {

        /**
         * 输出：
         * class com.test.TestJVM.classloader.CL
         * --------------------
         * class CL
         * class com.test.TestJVM.classloader.CL
         */

        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.test.TestJVM.classloader.CL");
        System.out.println(clazz);
        System.out.println("--------------------");
        clazz = Class.forName("com.test.TestJVM.classloader.CL");
        System.out.println(clazz);
    }

}

class CL{
    static {
        System.out.println("class CL");
    }
}

