package com.test.TestJVM.memory;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-15 22:09
 * @from:
 **/

public class MyMemoryTest2 {
    private int length;

    public int getLength() {
        return length;
    }

    public void test() throws InterruptedException {
        length++;
        Thread.sleep(1);
        test();
    }

    public static void main(String[] args) {
        //测试调整虚拟机栈内存大小为：  -Xss160k，此处除了可以使用JVisuale监控程序运行状况外还可以使用jconsole
        MyMemoryTest2 memoryTest2 = new MyMemoryTest2();
        try {
            memoryTest2.test();
        } catch (Throwable e) {
            System.out.println(memoryTest2.getLength());//打印最终的最大栈深度为：2587
            e.printStackTrace();
        }
    }
}
