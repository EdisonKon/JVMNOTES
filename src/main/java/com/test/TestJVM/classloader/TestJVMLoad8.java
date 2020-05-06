package com.test.TestJVM.classloader;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 *
 **/

public class TestJVMLoad8 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(FinalTest.x);
    }

}

class FinalTest{
    public static final int x = 3;
    static {
        System.out.println("finaltest staic block");
    }
}


