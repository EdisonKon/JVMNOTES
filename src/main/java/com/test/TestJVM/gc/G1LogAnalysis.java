package com.test.TestJVM.gc;


/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-21 15:52
 * @from
 *
 * G1日志分析
 * 虚拟机相关参数：
 * -verbose:gc 输出虚拟机中详细的gc日志
 * -Xms10m  代表堆初始值是10m
 * -Xmx10m  代表堆最大是10m
 * -Xmn5m  代表新生代大小5m
 * -XX:+UseG1GC 表示垃圾收集器使用G1
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:MaxGCPauseMillis=200m 设置垃圾收集最大停顿时间
 *
 **/
public class G1LogAnalysis {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] bytes1 = new byte[size];
        byte[] bytes2 = new byte[size];
        byte[] bytes3 = new byte[size];
        byte[] bytes4 = new byte[size];
        System.out.println("hello world");
    }
}
