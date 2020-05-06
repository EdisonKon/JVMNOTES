package com.test.TestJVM.classloader;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *   注意：初始化只会有一次，而且是对于 静态变量/代码块 来说，如果有非静态变量（实例变量），
 *        那么每实例化一次就会初始化一次，如下的 Parent2 staic block 666
 **/

public class TestJVMLoad10 {

    static {
        System.out.println("TestJVMLoad10 staic block");
    }

    public static void main(String[] args) {
        /**
         * 输出：
         *   TestJVMLoad10 staic block
         *   ------------------
         *   Parent2 staic block
         *   Parent2 staic block 666
         *   ------------------
         *   Parent2 staic block 666
         *   ------------------
         *   3
         *   ------------------
         *   3
         *   ------------------
         *   Child2 staic block
         *   4
         *
         */
        Parent2 parent2;
        System.out.println("------------------");
        parent2 = new Parent2();
        System.out.println("------------------");
        Parent2 parentx = new Parent2();
        System.out.println("------------------");
        System.out.println(parent2.a);
        System.out.println("------------------");
        System.out.println(parentx.a);
        System.out.println("------------------");
        System.out.println(Child2.b);

    }

}

class Parent2{
    static int a = 3;
    Parent2(){
        System.out.println("Parent2 staic block 666 ");
    }

    static {
        System.out.println("Parent2 staic block");
    }
}

class Child2 extends Parent2{
    static int b = 4;
    static {
        System.out.println("Child2 staic block");
    }
}

