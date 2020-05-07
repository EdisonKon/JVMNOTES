package com.test.TestJVM.classloader;

import java.io.IOException;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 *
 **/

public class TestJVMLoad17 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        TestJVMLoad16 testJVMLoad16 = new TestJVMLoad16("t16");

        Class<?> clazz = testJVMLoad16.loadClass("com.test.TestJVM.classloader.TestASimple");

        System.out.println(clazz.hashCode());
        //如果注释掉该行，则不会主动使用实例化cat的代码，则不会进行加载cat class（不一定会加载）
        Object o = clazz.newInstance();
//        Class<?> clazz = testJVMLoad16.loadClass("com.test.TestJVM.classloader.TestASimple");
//
//        System.out.println(clazz.hashCode());
    }

}

