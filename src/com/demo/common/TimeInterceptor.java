package com.demo.common;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeInterceptor implements HandlerInterceptor {

    private long start;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        start=System.currentTimeMillis();

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        long end=System.currentTimeMillis();
        System.out.println("目标处理方法耗费的时间："+(end-start)+"ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        long end=System.currentTimeMillis();
        System.out.println("处理本次请求耗费的时间："+(end-start)+"ms");
    }
}
