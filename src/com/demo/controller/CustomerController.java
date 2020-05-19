package com.demo.controller;

import com.demo.beans.CustomerInfo;
import com.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController  {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/list")
    public ModelAndView cstList() throws Exception {
        ModelAndView mav=new ModelAndView();
        mav.addObject("cstList",this.customerService.findAllCustomers());
        mav.setViewName("customer/list");
        return mav;
    }

    @GetMapping("/add")
    public String add(){
        return "customer/add";

    }

    @PostMapping("/add")
    public String add(CustomerInfo customerInfo, Model model){
       boolean result=this.customerService.saveInfo(customerInfo);
       model.addAttribute("msg",result?"保存成功！":"保存失败！");
       return "customer/add";
    }

}
