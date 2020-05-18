package com.test.TestJVM.gc;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-18 14:12
 * @from
 *
 *
 * -XX:PretenureSizeThreshold=1048576
 * -XX:+UseSerialGC
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 *
 * 指定收集器是serial收集器 并且设置对象分配方式
 *  * -XX:PretenureSizeThreshold=1111 表示只要超过1111字节,那么创建的对象就不会在新生代中分配
 *  *             ↑ 需要使用 单线程收集器 -XX:+UseSerialGC
 **/
public class MyGcTest2 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAllco1 = new byte[5 * size];

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("111111111");

    }
}
