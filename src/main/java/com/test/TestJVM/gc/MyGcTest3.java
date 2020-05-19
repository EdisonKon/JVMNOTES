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
 * -XX:+PrintCommandLineFlags 打印命令行参数
 * -XX:MaxTenuringThreshold=5 晋升老年代的最大存活年龄,G1 默认值是15,CMS是6
 * -XX:+PrintTenuringDistribution 打印年龄分组的对象
 *
 * 经历了多次gc后,存活的对象会在survivor和to中存活,在gc算法中,每经过一次survivor到to的情况就会+1岁
 * 当某个对象在到了某个低于指定年龄(15)的时候,但是此时对象的总大小已经大于survivor/to的总大小的50%,
 * 那么该对象直接进入老年代,不用等到年龄(15)再进入,并且该年龄值会被系统自动调整
 *
 * 指定收集器是serial收集器 并且设置对象分配方式
 *  * -XX:PretenureSizeThreshold=1111 表示只要超过1111字节,那么创建的对象就不会在新生代中分配
 *  *             ↑ 需要使用 单线程收集器 -XX:+UseSerialGC
 **/
public class MyGcTest3 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAllco1 = new byte[2 * size];
        byte[] myAllco2 = new byte[2 * size];
        byte[] myAllco3 = new byte[2 * size];
        byte[] myAllco4 = new byte[2 * size];

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("111111111");

    }
}
