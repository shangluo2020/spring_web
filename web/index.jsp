<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2020/3/29
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
    <style type="text/css">
        div a{
            text-decoration: none;
            font-size:25px;
            font-weight: bold;
            font-family: "楷体";
        }
    </style>
    <script src="js/main.js" type="text/javascript"></script>
</head>
<body>
<div>
<a href="${pageContext.request.contextPath}/prd/list">获取商品信息</a><br><br>
<a href="${pageContext.request.contextPath}/customer/list">查看顾客列表</a><br><br>
<a href="${pageContext.request.contextPath}/prd/add">录入新商品</a><br><br>
<a href="${pageContext.request.contextPath}/customer/add">录入新顾客</a><br><br>
    <a href="${pageContext.request.contextPath}/prd/test">测试</a><br><br>
<a href="${pageContext.request.contextPath}/prd/add_ajax.jsp">Ajax录入新商品</a><br><br>
<a href="${pageContext.request.contextPath}/file/upload.jsp">文件上传</a><br><br>
    <a href="${pageContext.request.contextPath}/file/list">文件列表</a><br><br>
</div>
<br>
<img src="img/32.jpg" alt="许光汉" width="290px" height="333px" >
<br><br><br>
<button onclick="show();">test</button>
</body>
</html>
