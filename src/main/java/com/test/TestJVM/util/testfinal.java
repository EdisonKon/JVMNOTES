package com.test.TestJVM.util;


/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-23 10:15
 * @from
 **/
public class testfinal {
    public static final int z = 1;

    public static int getZ() {
        return z;
    }
    public void test(){
//        z = 2;
        //final 除了初始化时候可以,其余方法不能指定z的值
    }
}
