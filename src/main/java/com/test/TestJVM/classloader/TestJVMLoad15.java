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
 *  对于数组实例来说，其类型是由jvm在运行期间动态生成的，表示为class [LTestJVM.classloader.MyParent4;
 *
 *  但是其classloader与对象的类型的加载器是一致的,也就是例如String的加载器就是bootstrap加载器,自定义的类就是app的类加载器
 *
 *  对象类型是原生类型的情况,其加载器为null
 *
 **/

public class TestJVMLoad15 {
    public static void main(String[] args) throws IOException {

        /**
         * 输出：
         * null
         * ------------------
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * ------------------
         * null
         */

        String[] strs = new String[2];
        System.out.println(strs.getClass().getClassLoader());
        System.out.println("------------------");
        TestJVMLoad15[] t15 = new TestJVMLoad15[2];
        System.out.println(t15.getClass().getClassLoader());
        System.out.println("------------------");
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());
        System.out.println("------------------");

    }

}

