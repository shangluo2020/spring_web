<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2020/3/29
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表页面</title>
</head>
<style>
    table tr td{
        border:1px solid black;
        height: 50px;
        text-align: center;
    }
    table{
        border-collapse: collapse;
    }
</style>
<body>
<h2>商品列表页面</h2>
<hr>
<c:if test="${not empty prdList}">
    <table>
        <thead>
        <tr>
            <td>商品编号</td>
            <td>商品类别</td>
            <td>商品名称</td>
            <td>商品描述</td>
            <td>商品价格</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${prdList}" var="p">
            <tr>
                <td>${p.prdId}</td>
                <td>${p.typeId}</td>
                <td>${p.prdName}</td>
                <td>${p.desc}</td>
                <td>${p.price}</td>
                <td>
                    <a style="color:red; text-decoration: none;" href="${pageContext.request.contextPath}/prd/edit/${p.prdId}">编辑</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
