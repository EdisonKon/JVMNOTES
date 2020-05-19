package com.test.TestJVM.gc;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-18 14:12
 * @from
 *
 * 经历了多次gc后, 存活的对象会在survivor和to中存活, 在gc算法中, 每经过一次survivor到to的情况就会+1岁
 * 当某个对象在到了某个低于指定年龄(15)的时候,但是此时对象的总大小已经大于survivor/to的总大小的50%,
 * 那么该对象直接进入老年代,不用等到年龄(15)再进入,并且该年龄值会被系统自动调整
 * 例如
 * 2020-05-19T09:59:11.785-0800: [GC (Allocation Failure) 2020-05-19T09:59:11.785-0800: [ParNew
 * Desired survivor size 3145728 bytes, new threshold 1 (max 3)  [当前内存占用是3m,也就是60%,那么这次新的gc的时候 new threshold调整为 1(岁)]
 * - age   1:    3145848 bytes,    3145848 total
 * - age   2:         64 bytes,    3145912 total
 * - age   3:     343992 bytes,    3489904 total
 * : 41510K->3500K(46080K), 0.0018584 secs] 42981K->4972K(199680K), 0.0018930 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
 * 5555555555555
 * 2020-05-19T09:59:12.793-0800: [GC (Allocation Failure) 2020-05-19T09:59:12.793-0800: [ParNew
 * Desired survivor size 3145728 bytes, new threshold 3 (max 3)  [当前内存占用是1m,不到60%,那么这次新的gc的时候 new threshold调整回 3(岁)]
 * - age   1:         72 bytes,         72 total
 * : 44224K->46K(46080K), 0.0032223 secs] 45696K->4940K(199680K), 0.0032573 secs] [Times: user=0.03 sys=0.01, real=0.00 secs]
 *
 *
 * -verbose:gc gc信息
 * -Xmx200m 最大200m堆
 * -Xmn50m  50m的新生代
 * -XX:TargetSurvivorRatio=60  占用survivor/to的60%大小直接晋升老年代并调整晋升年龄
 * -XX:+PrintTenuringDistribution 打印年龄分组的对象
 * -XX:+PrintGCDetails  打印gc详情
 * -XX:+PrintGCDateStamps 打印gc时间戳
 * -XX:+UseConcMarkSweepGC 老年代使用cms
 * -XX:+UseParNewGC 新生代使用parnew
 * -XX:MaxTenuringThreshold=3 最大晋升老年代的年龄 = 3
 *
 **/
public class MyGcTest4 {
    public static void main(String[] args) throws Exception{
        int size = 512 * 1024;
        byte[] myAllco1 = new byte[ size];
        byte[] myAllco2 = new byte[ size];
        MyGc();
        Thread.sleep(1000);
        System.out.println("111111111");
        MyGc();
        Thread.sleep(1000);
        System.out.println("2222222222");
        MyGc();
        Thread.sleep(1000);
        System.out.println("333333333333");
        MyGc();
        Thread.sleep(1000);
        System.out.println("44444444444444");

        byte[] myAllco11 = new byte[ 2*size];
        byte[] myAllco12 = new byte[ 2*size];
        byte[] myAllco13 = new byte[ 2*size];

        MyGc();
        Thread.sleep(1000);
        System.out.println("5555555555555");

        MyGc();
        Thread.sleep(1000);
        System.out.println("6666666666666");

        System.out.println("?????????????");

    }

    private static void MyGc(){
        for (int i = 0; i < 40; i++) {
            byte[] ba = new byte[1024*1024];
        }
    }
}
