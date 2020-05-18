package com.test.TestJVM.gc;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-18 14:12
 * @from
 *
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8  代表eden和survivor的比例是8:1:1
 *
 **/
public class MyGcTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAllco1 = new byte[2 * size];
        byte[] myAllco2 = new byte[2 * size];
        byte[] myAllco3 = new byte[3 * size];
        byte[] myAllco4 = new byte[3 * size];

        System.out.println("111111111");

    }
}
