package com.demo.common;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MyConverter implements GenericConverter {
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        ConvertiblePair pair=new ConvertiblePair(String.class, Date.class);
        Set<ConvertiblePair> set=new HashSet<>();
        set.add(pair);
        return set;
    }

    @Override
    public Object convert(Object o, TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
        Object result=null;
        if(typeDescriptor.getObjectType()==String.class&&
                typeDescriptor1.getObjectType()==Date.class){
            if(o!=null){
                String str=o.toString();
                if(str.length()>0){
                    try {
                        result=sdf.parse(str);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

        return result;
    }
}
