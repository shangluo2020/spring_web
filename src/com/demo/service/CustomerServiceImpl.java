package com.demo.service;

import com.demo.beans.CustomerInfo;
import com.demo.dao.CustomerDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;

@Service("customerService")

public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerDao customerDao;

    @Override
    @Transactional(readOnly = true)
    public List<CustomerInfo> findAllCustomers() {
       // System.out.println("顾客的记录条数是："+this.customerDao.count());

        CustomerInfo info=this.customerDao.findInfoById(7);
        if(info!=null){
            //System.out.println("7号顾客找到了,姓名是："+info.getLastName()+ info.getFirstName()+",出生日期是："+info.getDob()+",电话是："+info.getPhone());
        }else{
           // System.out.println("你输入的7号顾客编号不存在！");
        }
        return this.customerDao.findAllCustomers();
    }


    @Override
    @Transactional
    public boolean saveInfo(CustomerInfo customerInfo) {
        return this.customerDao.saveInfo(customerInfo)>0;
    }


}
