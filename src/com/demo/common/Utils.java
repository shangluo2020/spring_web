package com.demo.common;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Utils {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");

    public String formateDate(Date date){
        if(date==null){
            return null;
        }
        return sdf.format(date);
    }
}
