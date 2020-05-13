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
