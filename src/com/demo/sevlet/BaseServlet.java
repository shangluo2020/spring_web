package com.demo.sevlet;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {

    public <T> T getService(String serviceName,Class<T> serviceType){
        WebApplicationContext context= WebApplicationContextUtils.findWebApplicationContext(super.getServletContext());
        return context.getBean(serviceName,serviceType);
    }
}
