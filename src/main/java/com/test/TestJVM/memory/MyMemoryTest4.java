package com.test.TestJVM.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-15 22:49
 * @from:
 *
 * 方法区产生内存溢出
 * -XX:MaxMetaspaceSize=10m
 * 设置最大元空间大小
 *
 **/

public class MyMemoryTest4 {
    public static void main(String[] args) {
//        whiletrue();
        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyMemoryTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj, method, args1, proxy)->{
                proxy.invokeSuper(obj,args1);
                return null;
            });
//            System.out.println("enhancer");
            enhancer.create();
        }
    }

    //用于测试jmap
    public static void whiletrue(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("whiletrue");
        }
    }
}
