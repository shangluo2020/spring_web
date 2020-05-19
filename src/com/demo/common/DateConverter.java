package com.demo.common;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String s) {
        Date result=null;
        if(s!=null&&s.length()>0){
            try {
                result=this.sdf.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
