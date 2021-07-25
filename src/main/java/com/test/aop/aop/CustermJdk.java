package com.test.aop.aop;

import org.springframework.cglib.proxy.Proxy;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustermJdk implements InvocationHandler {
    private Object target;
    CustermJdk(Object target){
        super();
        this.target= target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("HELLO");
        method.invoke(target,args);
        System.out.println("BYE");
        return null;
    }
    public Object getProxy(){
        return  Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),this.target.getClass().getInterfaces(),this::invoke);
    }
}
