package com.demo.dao;

import com.demo.beans.CustomerInfo;

import java.util.List;

public interface CustomerDao {
    public List<CustomerInfo> findAllCustomers();

    public int count();

    CustomerInfo findInfoById(Integer customerId);

    int saveInfo(CustomerInfo customerInfo);
}
