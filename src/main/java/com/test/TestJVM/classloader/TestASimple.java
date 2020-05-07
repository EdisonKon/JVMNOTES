package com.test.TestJVM.classloader;

import java.io.IOException;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 **/

public class TestASimple {
    public TestASimple() {
        System.out.println(" Simple is load by " + this.getClass().getClassLoader());

        new TestACat();
    }

    public static void main(String[] args) throws IOException {
        TestASimple t = new TestASimple();
    }

}

