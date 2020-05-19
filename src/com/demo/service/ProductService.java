package com.demo.service;

import com.demo.beans.ProductInfo;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    List<ProductInfo> findAllProducts() throws SQLException;

    boolean saveInfo(ProductInfo prdInfo);

    ProductInfo findProductById(Integer prdId);
}
