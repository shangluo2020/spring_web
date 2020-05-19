package com.demo.proxy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
//        Target target = new Target();
//
//        Showable proxy = (Showable) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("这是目标方法之前要做的事：");
//                Object result = method.invoke(target, args);
//                System.out.println("这是目标方法之后要做的事：");
//                return result;
//            }
//        });
//
//        proxy.show();

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");

        Showable target=context.getBean("target2",Showable.class);
        target.show();
        target.display();






    }


}
