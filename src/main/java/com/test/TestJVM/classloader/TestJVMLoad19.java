package com.test.TestJVM.classloader;

//import com.sun.crypto.provider.AESKeyGenerator;

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

public class TestJVMLoad19 {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 输出:
         * sun.misc.Launcher$ExtClassLoader@355da254
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         */
//        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
//        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(TestJVMLoad19.class.getClassLoader());
    }

}

