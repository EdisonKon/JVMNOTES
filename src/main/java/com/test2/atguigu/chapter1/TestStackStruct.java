package com.test2.atguigu.chapter1;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-27 14:36
 * @from
 **/
public class TestStackStruct {
    //只要有static代码/代码块,就会有<clinit>的预编译方法
    static{
        i=10;
    }
    static int i =1;

    public static void main(String[] args) {
//        int i = 2 + 3;

        int i = 1;
        int j = 2;
        int k = i + j;

    }

    public int gettttt() {
        return i;
    }
}
