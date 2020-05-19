package com.demo.mapper;

import com.demo.beans.ProductTypeInfo;

import java.util.List;

public interface ProductTypeMapper {

    List<ProductTypeInfo>  findAllTypes();
}
