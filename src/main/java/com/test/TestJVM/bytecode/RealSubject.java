package com.test.TestJVM.bytecode;


/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-15 13:43
 * @from
 **/
public class RealSubject implements Subject{
    @Override
    public void reuqest() {
        System.out.println(" from real subject");
    }
}
