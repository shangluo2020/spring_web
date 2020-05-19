package com.demo.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start=System.nanoTime();
        Object result=null;
        try{
            result=methodInvocation.proceed();
        }catch(Throwable throwable){
            throwable.printStackTrace();

        }finally{
            long end=System.nanoTime();
            System.out.println("耗时："+(end-start)+"ns");
        }

        return result;
    }
}
