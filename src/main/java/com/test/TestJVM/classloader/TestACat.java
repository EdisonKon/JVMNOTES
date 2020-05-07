package com.test.TestJVM.classloader;

import java.io.IOException;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 **/

public class TestACat {
    public TestACat() {
        System.out.println(" cat is load by " + this.getClass().getClassLoader());

    }

    public static void main(String[] args) throws IOException {
        TestACat t = new TestACat();

    }

}

