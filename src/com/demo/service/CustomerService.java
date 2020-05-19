package com.demo.service;

import com.demo.beans.CustomerInfo;

import java.util.List;

public interface CustomerService {

    List<CustomerInfo> findAllCustomers();

    boolean saveInfo(CustomerInfo customerInfo);
}
