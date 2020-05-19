<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2020/4/16
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>追加商品页面</title>
</head>
<body>
<h2>追加商品页面</h2>
<hr>
<form:form action="${pageContext.request.contextPath}/prd/add" method="post" modelAttribute="prdInfo">
    商品名称：<input type="text" name="prdName"><form:errors path="prdName"></form:errors><br>
    商品类别：<select name="typeId" id="typeId">
    <option value="0">请选择类别</option>
    <c:if test="${not empty typeList}">
        <c:forEach items="${typeList}" var="t">
            <option value="${t.typeId}">${t.typeName}</option>
        </c:forEach>
    </c:if>
</select><br>
    商品描述：<textarea name="desc" id="desc" cols="30" rows="5"></textarea><br>
    商品价格：<input type="text" name="price"> <form:errors path="price"></form:errors><br>
    <%--生产日期：<input type="text" name="produceDate">--%>
    <%--<form:errors path="productDateIsVaild"></form:errors><br>--%>
    <%--联系电话：<input type="text" name="phone">--%>
    <%--<form:errors path="phone"></form:errors><br>--%>
    <button type="submit">提交</button>

    <%--<form:errors path="*"></form:errors>--%>

</form:form>
<h2>${param.msg}</h2>

<%--<c:if test="${not empty msgs}">--%>
    <%--<ul>--%>
        <%--<c:forEach items="${msgs}" var="m">--%>
            <%--<li>${m}</li>--%>
        <%--</c:forEach>--%>
    <%--</ul>--%>

<%--</c:if>--%>
<hr>
<c:if test="${not empty  prdInfo.prdName && prdInfo.price >0&&prdInfo.price<=100}">
    你录入的商品信息如下：<br>
    商品编号：${prdInfo.prdId}<br>
    商品名称：${prdInfo.prdName}<br>
    类别编号：${prdInfo.typeId}<br>
    商品描述：${prdInfo.desc}<br>
    商品价格：${prdInfo.price}<br>
</c:if>
</body>
</html>
