package com.test.TestJVM.bytecode;


import java.util.Date;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-14 10:48
 * @from
 *
 * 针对于方法调用动态分派的过程,虚拟机会在类的方法区建立一个虚方法表的数据结构(virtual method table , 简称vtable)
 * 针对于invokeinterface的指令,虚拟机会在类的方法区建立一个接口方法表的数据结构(interface method table , 简称itable)
 *
 *
 **/
public class MyTest7 {
    public void test(Animal animal){
        System.out.println("animal animal");
    }
    public void test(Cat cat){
        System.out.println("cat cat");
    }
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("bollo");
        dog.test(new Date());

        //输出: 动态分派 - 重写
        //Animal str = bollo
        //dog date = date
        MyTest7 myTest7 = new MyTest7();
        Animal cat = new Cat();
        myTest7.test(cat);
        //输出: 静态分派 - 重载
        //animal animal
    }

}
class Animal{
    public void test(String str){
        System.out.println("Animal str = " + str);
    }
    public void test(Date date){
        System.out.println("Animal date = " + date);
    }
}

class Cat extends Animal{
    @Override
    public void test(String str){
        System.out.println("Cat str = " + str);
    }
    @Override
    public void test(Date date){
        System.out.println("Cat date = " + date);
    }
}

class Dog extends Animal{
    @Override
    public void test(String str){
        System.out.println("dog str = " + str);
    }
    @Override
    public void test(Date date){
        System.out.println("dog date = " + date);
    }
}