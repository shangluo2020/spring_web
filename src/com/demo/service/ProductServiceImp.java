package com.demo.service;

import com.demo.beans.ProductInfo;
import com.demo.mapper.ProductMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;


@Service("productService")
public class ProductServiceImp implements ProductService {
    private static Logger logger = Logger.getLogger(ProductServiceImp.class);

    @Value("${db.url}")
    private String url;

    //根据bean的类型进行注入
    @Autowired
    @Qualifier("productMapper")
    private ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true,transactionManager = "transactionManager")
    public List<ProductInfo> findAllProducts() throws SQLException {

//        logger.debug("prdMapper=productMapper:" + (this.productMapper == this.productMapper));
//        logger.debug("url=" + (this.url));
        List<ProductInfo> list = null;
        try {
            list = this.productMapper.findAllProducts();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean saveInfo(ProductInfo prdInfo) {
        return this.productMapper.saveInfo(prdInfo)>0;
    }

    @Override
    public ProductInfo findProductById(Integer prdId) {
         return this.productMapper.findProductById(prdId);

    }

    @PostConstruct
    public void init() {
        //logger.debug("================init被执行了。。");
       // logger.debug("此时，该bean对象中的属性是否已经被注入了依赖: " + !(this.prdMapper == null));
    }




    public void init1() {
        //logger.debug("================init1被执行了。。。。。");
    }

    @PreDestroy
    public void destory() {
        //logger.debug("================destory被执行了。。。");
    }
}
