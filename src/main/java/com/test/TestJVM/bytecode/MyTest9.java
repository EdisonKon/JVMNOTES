package com.test.TestJVM.bytecode;


/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-27 14:02
 * @from
 **/
public class MyTest9 {
    public static void main(String[] args) {
        int i = 10;
        int i2 = 10;
        i++;
        ++i2;

        int i3 = 10;
        int i4 = i3++;

        int i5 = 10;
        int i6 =++i5;

        int i7 = 10;
        i7=i7++;

        int i8 = 10;
        i8 = ++i8;

        int i9 = 10;
        i9 = ++i9 + i9++;
        System.out.println(i9);

        int i10 = 10;
        i10 = ++i10 + ++i10;
        System.out.println(i10);
    }
}
