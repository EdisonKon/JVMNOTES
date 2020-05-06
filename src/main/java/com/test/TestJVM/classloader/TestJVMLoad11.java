package com.test.TestJVM.classloader;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 *
 **/

public class TestJVMLoad11 {
    public static void main(String[] args)  {
        /**
         * 输出：
         * Parent3 staic block
         * 3
         * do Something
         */
        System.out.println(Child3.a);
        Child3.doSomething();
    }

}

class Parent3{
    static int a = 3;
    static {
        System.out.println("Parent3 staic block");
    }

    static void doSomething(){
        System.out.println("do Something");
    }
}

class Child3 extends Parent3{
    static int b = 4;
    static {
        System.out.println("Child3 staic block");
    }

}
