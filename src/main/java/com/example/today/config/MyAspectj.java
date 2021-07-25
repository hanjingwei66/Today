package com.example.today.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Method;

@Configuration
@Aspect
public class MyAspectj {
    @Autowired
    private ProxyFactoryBean proxyFactoryBean;
    private final HotSwappableTargetSource hotSwappableTargetSource;

    public MyAspectj(HotSwappableTargetSource hotSwappableTargetSource) {
        this.hotSwappableTargetSource = hotSwappableTargetSource;
    }

    @Pointcut("execution(* login(..))")
    private void anyHelloMethod() {
    }
    @Pointcut("execution(* hello(..))")
    private void hello() {
    }

    @Before("anyHelloMethod()")
    public void beforeDosomethine() {
        System.out.println("hjw");
    }
//    com.example.today.controller.WebController.login()
//    PessimisticLockingFailureException
    @AfterReturning("anyHelloMethod()")
    public void afterDosomethine() {
        System.out.println("dsb");
    }
    //execution(String com.example.today.service.HotSwappable.hello())"+"&&"+"@annotation(com.example.today.MyAnnotation.Idempotent)
    @Around("hello()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//         start stopwatch
        System.out.println(pjp.getArgs());
        System.out.println(pjp.getThis());
        System.out.println(pjp.getTarget());
        System.out.println(pjp.getSignature());
        System.out.println(pjp.toString());
        System.out.println("123");
//        Object target = hotSwappableTargetSource.getTarget();
//        System.out.println(target.getClass());
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }

}

