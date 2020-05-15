package com.test.TestJVM.bytecode;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-15 13:41
 * @from
 **/
public class DynamicSubject implements InvocationHandler {

    private Object sub;

    public DynamicSubject(Object sub) {
        this.sub = sub;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling");
        method.invoke(this.sub,args);
        System.out.println("after calling");
        return null;
    }
}
