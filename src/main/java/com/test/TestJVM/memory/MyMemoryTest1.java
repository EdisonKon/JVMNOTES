package com.test.TestJVM.memory;


import java.util.ArrayList;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-15 16:23
 * @from
 *
 * 线程私有:
 * 虚拟机栈: Stack frame 栈帧
 * 程序计数器 (program count):
 *
 * 本地方法栈: 主要用于执行本地方法(native)
 * 堆 heap: jvm管理的最大的一块内存空间,相关 - 垃圾收集器(分代收集算法)
 *      新生代:  Eden
 *              From survivor
 *              to survivor
 *      老年代:
 * 方法区(method area): 存储class对象的内容(元数据)
 *      永久代: 从jdk1.8开始,废弃了永久代(per gen),而使用了元空间(meta space)
 * 运行时常量池:
 * 直接内存: 堆外内存 与jvm nio 密切相关,jvm通过堆上的DirectByteBuffer来直接操作该内存
 *
 **/
public class MyMemoryTest1 {

    //-Xms5m -Xmx5m
    //最小的堆5m 最大的堆 5m
    //-XX:+HeapDumpOnOutOfMemoryError 在oom异常时候打印堆信息

    public static void main(String[] args) {
        List<MyMemoryTest1> list = new ArrayList<>();
        for(;;){
            list.add(new MyMemoryTest1());
        }
    }

    int length=0;
    public void test() throws InterruptedException {
        length++;
        Thread.sleep(1);
        test();
    }

}
