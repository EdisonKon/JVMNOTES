package com.test.TestJVM.bytecode;


/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-13 11:19
 * @from
 *
 * 栈帧: stack frame
 *
 * 栈帧是一种用于帮助虚拟机执行方法调用与方法执行的数据结构
 *
 * 栈帧是一种数据结构,封装了方法的局部变量表,动态链接信息,返回地址,操作数栈等信息
 *
 * 局部变量表:slot
 *  局部变量表的容量以变量槽为最小单位，每个变量槽都可以存储32位长度的内存空间，例如boolean、byte、char、short、int、float、reference。
 *  对于64位长度的数据类型（long，double），虚拟机会以高位对齐方式为其分配两个连续的Slot空间，也就是相当于把一次long和double数据类型读写分割成为两次32位读写。
 *
 *
 * 动态连接信息:符号引用,直接引用
 * 某些符号引用在类加载阶段或第一次使用时转换为直接引用,此种为静态解析
 * 另一些符号引用是在每次运行期间转换为直接引用,这种转换是动态链接/解析
 * 提现为java的多态:
 *      Animal a = new Cat();
 *      a.sleep();
 *      a = new Dog();
 *      a.sleep();
 *      a = new Tiger();
 *      a.sleep();
 *      在字节码中只能看到Animal的实例方法
 *
 *
 * 返回地址:操作的返回位置
 *  当一个方法开始执行后，只有2种方式可以退出这个方法 ：
 *   方法返回指令 ： 执行引擎遇到一个方法返回的字节码指令，这时候有可能会有返回值传递给上层的方法调用者，这种退出方式称为正常完成出口。
 *   异常退出 ： 在方法执行过程中遇到了异常，并且没有处理这个异常，就会导致方法退出。
 *
 * 无论采用任何退出方式，在方法退出之后，都需要返回到方法被调用的位置，程序才能继续执行，方法返回时可能需要在栈帧中保存一些信息。
 *
 * 操作数栈:与局部变量表类似,记录Java类型的操作数
 *
 * 方法调用字节码:
 * 1 invokeinterface : 调用接口中的方法,是在运行期决定的,决定到底要调用哪个实现接口的类的特定方法
 * 2 invokestatic : 调用静态方法
 * 3 invokespical : 调用自己的私有方法,构造方法<init> 以及父类的方法
 * 4 invokevirtual : 调用虚方法,运行期动态查找的过程(与多态相关).
 * 5 invokedynamic : 动态调用方法
 *
 *
 * invokestatic
 * invokespical
 * 这2种调用可以在解析的时候就直接把引用转为直接引用
 * 包括4种方法: 静态方法,父类方法,构造方法,私有方法
 * 以上4类方法称作非虚方法,是静态解析,他们是在类加载的过程中就可以把符号引用转换为直接引用的情况
 **/
public class MyTest4 {

    public static void test(){
        System.out.println("test invoke");
    }

    public static void main(String[] args) {
        test();
    }
}
