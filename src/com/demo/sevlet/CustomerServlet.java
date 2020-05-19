package com.demo.sevlet;

import com.demo.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/customerServlet"})
public class CustomerServlet extends BaseServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String flag=req.getParameter("flag");
       if("list".equals(flag)){

            req.setAttribute("cstList",super.getService("customerService", CustomerService.class).findAllCustomers());
            req.getRequestDispatcher("/customer/list.jsp").forward(req,resp);

       }
    }
}
