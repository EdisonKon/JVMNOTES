package com.test.TestJVM.classloader;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 *
 **/

public class TestJVMLoad9 {

    static {
        System.out.println("TestJVMLoad9 staic block");
    }

    public static void main(String[] args) {
        /**
         * 输出：
         * TestJVMLoad9 staic block
         * Parent staic block
         * Child staic block
         * 4
         */
        System.out.println(Child.b);
    }

}

class Parent{
    static int a = 3;
    static {
        System.out.println("Parent staic block");
    }
}

class Child extends Parent{
    static int b = 4;
    static {
        System.out.println("Child staic block");
    }
}

