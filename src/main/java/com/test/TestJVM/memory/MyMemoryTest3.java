package com.test.TestJVM.memory;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-15 22:09
 * @from:
 * 产生死锁的代码
 **/

public class MyMemoryTest3 {

    private Object a = new Object();
    private Object b = new Object();
    public void getA(){
        System.out.println(Thread.currentThread()+"获取a");
        synchronized (a){
            System.out.println(Thread.currentThread()+"操作 a");
            try {
                Thread.sleep(1000);
                getB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread()+"获取a完成");
    }

    public void getB(){
        System.out.println(Thread.currentThread()+"获取b");
        synchronized (b){
            System.out.println(Thread.currentThread()+"操作 b");
            try {
                Thread.sleep(1000);
                getA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread()+"获取b完成");
    }

    public static void main(String[] args) {
        MyMemoryTest3 m3 = new MyMemoryTest3();
        new Thread(() -> m3.getA(),"Thread-a").start();
        new Thread(() -> m3.getB(),"Thread-b").start();
    }
}
