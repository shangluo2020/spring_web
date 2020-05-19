package com.demo.mapper;

import com.demo.beans.ProductInfo;

import java.sql.SQLException;
import java.util.List;

public interface ProductMapper {
    List<ProductInfo> findAllProducts() throws SQLException;


    int saveInfo(ProductInfo prdInfo);

    ProductInfo findProductById(Integer prdId);
}
