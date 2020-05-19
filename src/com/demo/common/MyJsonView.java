package com.demo.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class MyJsonView implements View {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String getContentType() {

        return "application/json";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //渲染
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");

        Object obj = map.get("prdList");
        objectMapper.writeValue(httpServletResponse.getOutputStream(), obj);


    }
}
