package com.test.TestJVM.classloader;

//import com.sun.crypto.provider.AESKeyGenerator;

import java.lang.reflect.Method;

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

public class TestJVMLoad20 {
    public static void main(String[] args) throws Exception {
        TestJVMLoad16 t161 = new TestJVMLoad16("load1");
        TestJVMLoad16 t162 = new TestJVMLoad16("load2");

        Class clazz1 = t161.loadClass("com.test.TestJVM.classloader.TestAPerson");
        Class clazz2 = t162.loadClass("com.test.TestJVM.classloader.TestAPerson");

        //输出true
        System.out.println(clazz1 == clazz2);

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();

        Method method1 = clazz1.getMethod("setTestAPerson",Object.class);
        method1.invoke(o1,o2);

    }

}

