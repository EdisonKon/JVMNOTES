package com.test.TestJVM.gc;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-18 14:12
 * @from
 *
 *
 * -XX:+UseConcMarkSweepGC
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 *
 *
 * 指定收集器是cms收集器
 *
 **/
public class MyGcTest5 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAllco1 = new byte[4 * size];
        System.out.println("111111111");
        byte[] myAllco2 = new byte[4 * size];
        System.out.println("222222222");
        byte[] myAllco3 = new byte[4 * size];
        System.out.println("333333333");
        byte[] myAllco4 = new byte[2 * size];
        System.out.println("444444444");


    }
}
