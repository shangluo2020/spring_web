package com.demo.proxy;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AopUtils {

    public void before(JoinPoint point) {
        System.out.println("这句话应该在目标方法之前输出！");
        System.out.println("kind：" + point.getKind() + ",signature:" + point.getSignature()
                + ",target:" + point.getTarget().getClass().getName());
    }

    public void afterReturning(Object value) {
        System.out.println("这是方法正常返回之后执行的代码！目标方法的返回值是：" + value);
    }

    public void afterThrowing(Exception ex) {
        System.out.println("目标方法出现异常了！ 异常是：" + ex.getMessage());
    }

    public void after() {
        System.out.println("目标方法结束了！");

    }

    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("先执行某些处理。。");
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("目标方法正常结束的处理。。");
        } catch (Throwable throwable) {
            System.out.println("目标方法出现异常后的处理。。");
            throwable.printStackTrace();
        } finally {
            System.out.println("目标方法结束后的处理。。");
        }
        return result;
    }
}
