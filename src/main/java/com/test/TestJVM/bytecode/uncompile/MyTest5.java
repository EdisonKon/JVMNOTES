package com.test.TestJVM.bytecode.uncompile;


/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-13 15:44
 * @from
 *
 * 方法的静态分派
 *
 * Grandpa p1 = new Father();
 * 以上代码,p1的静态类型是Grandpa,而它的实际类型(真正指向的类型)是Father
 *
 * 结论:
 *  Grandpa p1 在任何时候,p1的静态类型是不会改变的, 其实际类型可能会随着代码的改变而发生改变(多态的提现),确切的类型是在运行期间才可以确定
 *
 * public void test(Grandpa grandpa)
 * public void test(Father father)
 * public void test(Son son)
 * 方法重载对jvm来说是一种静态的行为,所以调用的时候是根据静态类型去确定调用哪个方法.这种调用是在编译器就可以确定的.
 **/
public class MyTest5 {
    public void test(Grandpa grandpa){
        System.out.println("grandpa = " + grandpa);
    }
    public void test(Father father){
        System.out.println("Father = " + father);
    }
    public void test(Son son){
        System.out.println("Son = " + son);
    }

    public static void main(String[] args) {
        Grandpa p1 = new Father();
        Grandpa p2 = new Son();

        MyTest5 myTest5 = new MyTest5();
        myTest5.test(p1);
        myTest5.test(p2);
        //输出:
        //grandpa = com.test.TestJVM.bytecode.uncompile.Father@355da254
        //grandpa = com.test.TestJVM.bytecode.uncompile.Son@4dc63996
    }
}

class Grandpa{

}
class Father extends Grandpa{

}
class Son extends Father{

}
