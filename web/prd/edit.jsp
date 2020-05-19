<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2020/4/27
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>编辑商品页面</title>
</head>
<body>
<h2>编辑商品</h2>
<hr>
<form:form method="post" action="${pageContext.request.contextPath}/prd/edit" modelAttribute="productInfo">

    商品编号：<input type="text" name="prdId" value="${productInfo.prdId}" readonly>
    <form:errors path="prdId"></form:errors><br>
    商品名称：<input type="text" name="prdName" value="${productInfo.prdName}">
    <form:errors path="prdName"></form:errors> <br><br>
    商品类别：<select name="typeId">
    <option value="0">请选择商品类别</option>
    <c:if test="${not empty typeList}">
    <c:forEach items="${typeList}" var="t">
    <option value="${t.typeId}">
        <c:if test="${t.typeId==productInfo.typeId}">selected</c:if>
            ${t.typeName}</option>
    </c:forEach>
    </c:if></select><br>
    商品描述：<textarea name="desc" id="desc" cols="30" rows="4">${productInfo.desc}</textarea><br>
    商品价格：<input type="text" name="price" value="${productInfo.price}">
    <form:errors path="price"></form:errors> <br>
    <button type="submit">提交</button>
    <br>
</form:form>

</body>
</html>
