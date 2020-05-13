package com.test.TestJVM.bytecode;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-12 11:30
 * @from
 * 编译后的代码
 *  0 new #2 <java/io/FileInputStream>
 *  3 dup
 *  4 ldc #3 <xx>
 *  6 invokespecial #4 <java/io/FileInputStream.<init>>
 *  9 astore_1
 * 10 new #5 <java/net/ServerSocket>
 * 13 dup
 * 14 sipush 888
 * 17 invokespecial #6 <java/net/ServerSocket.<init>>
 * 20 astore_2
 * 21 aload_2
 * 22 invokevirtual #7 <java/net/ServerSocket.accept>
 * 25 pop
 * 26 getstatic #8 <java/lang/System.out>
 * 29 ldc #9 <finally>
 * 31 invokevirtual #10 <java/io/PrintStream.println>
 * 34 goto 84 (+50)
 * 37 astore_1
 * 38 getstatic #8 <java/lang/System.out>
 * 41 ldc #9 <finally>
 * 43 invokevirtual #10 <java/io/PrintStream.println>
 * 46 goto 84 (+38)
 * 49 astore_1
 * 50 getstatic #8 <java/lang/System.out>
 * 53 ldc #9 <finally>
 * 55 invokevirtual #10 <java/io/PrintStream.println>
 * 58 goto 84 (+26)
 * 61 astore_1
 * 62 getstatic #8 <java/lang/System.out>
 * 65 ldc #9 <finally>
 * 67 invokevirtual #10 <java/io/PrintStream.println>
 * 70 goto 84 (+14)
 * 73 astore_3
 * 74 getstatic #8 <java/lang/System.out>
 * 77 ldc #9 <finally>
 * 79 invokevirtual #10 <java/io/PrintStream.println>
 * 82 aload_3
 * 83 athrow
 * 84 return
 **/
public class MyTest3 {

    /**
     * 对于java类种的每一个实例方法(非静态方法),都会有一个隐藏的对象this(编译后生成的字节码默认加的),位于方法的第一个参数位置
     * 所以我们可以使用该对象(this)的其他属性/方法,这个操作是编译器在编译代码时将对this的方法转化为对一个普通实例方法参数的访问,
     * 在运行期间由jvm调用实例方法时,自动向实例方法汇总传入this参数,在所有实例方法中至少会有一个this参数(即便无参也会有)
     *
     * stack=3, locals=4, args_size=1
     *
     * 为什么本地变量是4
     * 第一个变量是 this
     * 2. inputStream
     * 3. ss
     * 4. 某个try catch 捕获的异常对象,因为异常只会进入到某一个catch中,所以只会有一个变量被定义
     *
     * java字节码对异常的处理方式
     * 1. 统一采用异常表的方式对异常进行处理
     * 例:异常表
     * 0	0	26	37	cp_info #11
     * 1	0	26	49	cp_info #12
     * 2	0	26	61	cp_info #13
     * 3	0	26	73	cp_info #0
     * 2.在jdk1.4.2之前的版本不是使用1的方式,而是使用的特定的指令处理
     * 3.当异常处理存在finally语句块时,现代化jvm(1.7-之后)是讲finally的语句块拼接到每一个catch语句的后面
     *  也就是在异常表中有多少catch就会在每一个catch后拼接一次finally语句块
     *
     */
    public void test() {
        try{
            InputStream inputStream = new FileInputStream("xx");

            ServerSocket ss = new ServerSocket(888);
            ss.accept();

        }catch (FileNotFoundException fe){

        }catch (IOException ioe){

        }catch (Exception e){

        }finally {
            System.out.println("finally");
        }
    }

    int ix = 0;
    public int testRecursive(int i){
        if(i>0){
            ix++;
            ix++;
            ix++;
            return testRecursive(i/2);
        }
        return ix;
    }
}
