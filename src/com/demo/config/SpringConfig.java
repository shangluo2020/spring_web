package com.demo.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {"com.demo"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}))
@EnableTransactionManagement
public class SpringConfig {

    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource(){
        BasicDataSource basicDataSource=new BasicDataSource();
        basicDataSource.setDefaultAutoCommit(false);
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/store");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("chenlinong");

        return basicDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean s=new SqlSessionFactoryBean();
        s.setDataSource(dataSource);
        s.setTypeAliasesPackage("com.demo.beans");
        SqlSessionFactory factory=null;
        Resource[]  resources=new Resource[0];
        try {
            resources= new  PathMatchingResourcePatternResolver ().getResources("classPath:com/demo/dao/*Mapper.xml");
            s.setMapperLocations(resources);
            factory=s.getObject();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return factory;
    }


    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer m=new MapperScannerConfigurer();
        m.setBasePackage("com.demo.mapper");
        m.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return m;
    }

    @Bean
    public JdbcTemplate template(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
