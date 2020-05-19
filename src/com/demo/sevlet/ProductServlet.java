package com.demo.sevlet;

import com.demo.beans.ProductInfo;
import com.demo.common.Utils;
import com.demo.service.ProductService;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/prdServlet"})
public class ProductServlet extends BaseServlet {

    public static Logger logger=Logger.getLogger(ProductServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }

    protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String flag = request.getParameter("flag");
        if ("list".equals(flag)) {
            ProductService productService = super.getService("productService", ProductService.class);

            List<ProductInfo> list = null;
            try {
                list = productService.findAllProducts();
                request.setAttribute("prdList", list);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Date d=new Date();
            Utils utils=super.getService("utils",Utils.class);
            logger.debug("格式后的Date是： "+utils.formateDate(d));

            request.getRequestDispatcher("/prd/list.jsp").forward(request, response);

        }
    }
}
