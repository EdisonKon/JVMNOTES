package com.test.TestJVM.bytecode;


/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-13 15:44
 * @from
 *
 * 方法的动态分派
 *
 * 方法接受者: 到底是由哪个对象进行调用的.
 * invokevirtual字节码指令的查找流程 :
 *  1 先到操作数栈顶找到第一个元素,找到该对象对应的实际类型
 *  2 进行方法查找
 *      2.1 如果栈顶的该对象里有指定的方法(例子中为test()),且是可访问的权限,那么直接调用该方法并返回
 *      2.2 如果无法在该类种找到方法(或无访问权限),那么将由继承关系向上查找,直到可以执行的方法(如果一直找不到那就扔出异常)
 *
 *
 **/
public class MyTest6 {

    public static void main(String[] args) {
        Fruit p1 = new Apple();
        Fruit p2 = new Orange();

        p1.test();
        p2.test();

        p1 = new Orange();
        p1.test();
        //输出:
        //apple
        //orange
        //orange
    }
}

class Fruit{
    public void test(){
        System.out.println("Fruit");
    }
}

class Apple extends Fruit{
    @Override
    public void test(){
        System.out.println("Apple");
    }
}

class Orange extends Fruit{
    @Override
    public void test(){
        System.out.println("Orange");
    }
}
