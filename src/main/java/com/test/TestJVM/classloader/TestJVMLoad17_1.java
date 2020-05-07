package com.test.TestJVM.classloader;

import java.io.IOException;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 * 删除classpath下的编译好的.class文件
 *
 * 当只删除cat的class的情况下，会使用appclassloader进行加载simple，并且因为cat在simple内部，则会同样使用appclassloader进行加载
 * 但是classpath下无cat.class，所以会抛异常说找不到类
 *
 * 当只删除simple的class的情况下，委托appclassloader进行加载，但是classpath下无simple.class会使用自定义的16classloader进行加载simple，
 * 并且因为cat在simple内部，则会委托同样使用appclassloader进行加载，且存在cat.class文件则使用appclassloader加载成功
 *
 * + 子加载器所加载的类**可以访问**到父加载器加载的类
 * + 父加载器所加载的类**无法访问**到子加载器加载的类
 **/

public class TestJVMLoad17_1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        TestJVMLoad16 testJVMLoad16 = new TestJVMLoad16("t16");
        testJVMLoad16.setPath("J:\\");
        Class<?> clazz = testJVMLoad16.loadClass("com.test.TestJVM.classloader.TestASimple");

        System.out.println(clazz.hashCode());
        //如果注释掉该行，则不会主动使用实例化cat的代码，则不会进行加载cat class（不一定会加载）
        Object o = clazz.newInstance();
//        Class<?> clazz = testJVMLoad16.loadClass("com.test.TestJVM.classloader.TestASimple");
//
//        System.out.println(clazz.hashCode());
    }

}

