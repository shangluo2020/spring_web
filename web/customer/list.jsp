<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2020/4/11
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>顾客信息列表</title>
    <style>
        table tr td{
            border:2px solid black;
            height: 60px;
            text-align:center;
            font-weight: bold;
        }
        table {
            border-collapse: collapse;

        }
    </style>
</head>
<body>
<h2>顾客信息列表</h2>
<hr>
<form action="" method="post">
    请输入你要查找的顾客编号：<input type="text" name="cst_id">
    <button text="submit">搜索</button><br><br>
</form>
<c:if test="${not empty cstList}">
    <table>
        <thead>
        <tr>
            <td style="width: 75px;">顾客编号</td>
            <td style="width: 115px;">顾客姓名</td>
            <td style="width: 135px;">顾客出生日期</td>
            <td style="width: 155px;">顾客电话</td>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${cstList}" var="cst">
            <tr>
                <td>${cst.customerId}</td>
                <td>${cst.lastName} ${cst.firstName} </td>
                <td>${cst.dob}</td>
                <td>${cst.phone}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</c:if>
</body>
</html>
