package com.demo.config;

import com.demo.common.MyConverter;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.demo.common","com.demo.controller"})
public class SpringMVCConfig {

    @Bean
    public FormattingConversionService conversionService(){
        FormattingConversionServiceFactoryBean f=new FormattingConversionServiceFactoryBean();
        Set<GenericConverter> set=new HashSet<>();
        set.add(new MyConverter());
        f.setConverters(set);

        return f.getObject();

    }

    @Bean
    public InternalResourceViewResolver viewResolver1(){
        InternalResourceViewResolver r=new InternalResourceViewResolver();
        r.setPrefix("/");
        r.setSuffix(".jsp");
        r.setOrder(1000);
        return r;
    }

    @Bean
    public ResourceBundleViewResolver viewResolver2(){
        ResourceBundleViewResolver r=new ResourceBundleViewResolver();
        r.setBasename("my_view_define");
        r.setOrder(100);
        return r;
    }

    @Bean
    public XmlViewResolver xmlViewResolver(){
        XmlViewResolver x=new XmlViewResolver();
        ClassPathResource resource=new ClassPathResource("my_views.xml");
        x.setLocation(resource);
        x.setOrder(10);
        return x;
    }

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver c=new CommonsMultipartResolver();
        c.setDefaultEncoding("utf-8");
        c.setMaxUploadSize(26214400);
        c.setMaxInMemorySize(2048);
        c.setMaxUploadSizePerFile(5242880);
        return c;
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource r=new ResourceBundleMessageSource();
        r.setBasename("msg");
        return r;
    }

//    @Bean
//    public Validator validatorFactoryBean(MessageSource messageSource){
//         RequestMappingHandlerAdapter handlerAdapter;
//        LocalValidatorFactoryBean l=new LocalValidatorFactoryBean();
//        l.setProviderClass(HibernateValidator.class);
//        l.setValidationMessageSource(messageSource);
//
//        return l.getValidator();
//    }
}
