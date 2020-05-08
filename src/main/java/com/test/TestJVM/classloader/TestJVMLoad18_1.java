package com.test.TestJVM.classloader;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 *  如果将14的.class文件放到bootstrap加载器加载的位置
 *  /Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/classes
 *  那么将有bootstrap加载器进行加载
 *
 **/

public class TestJVMLoad18_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        TestJVMLoad16 t16 = new TestJVMLoad16("t16");
        t16.setPath("J:\\");
        Class<?> clazz = t16.loadClass("com.test.TestJVM.classloader.TestJVMLoad14");
        System.out.println("class:"+clazz.hashCode());
        System.out.println("class loader:"+clazz.getClassLoader());
    }

}

