<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2020/4/17
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>追加客户</title>
</head>
<body>
<h2>添加顾客页面</h2>
<hr>
<form action="${pageContext.request.contextPath}/customer/add" method="post">
    First Name:<input type="text" name="firstName"><br>
    Last Name:<input type="text" name="lastName"><br>
    出生日期:<input type="text" name="dob"><br>
    电话:<input type="text" name="phone"><br>
    <button type="submit">提交保存</button>

</form>
<h2>${msg}</h2>
<hr>
<c:if test="${not empty customerInfo.lastName&&customerInfo.firstName&&customerInfo.dob&&customerInfo.phone }">
    您刚才保存的顾客信息：<br><br>
    顾客名字：${customerInfo.lastName}-${customerInfo.firstName}<br>
    顾客出生日期：${customerInfo.dob}<br>
    顾客电话：${customerInfo.phone}<br>

</c:if>


</body>
</html>
