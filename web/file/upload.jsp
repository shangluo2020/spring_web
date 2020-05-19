<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2020/4/19
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>文件上传</title>
    <script type="text/javascript">
        window.onload = function (ev) {
            document.getElementById("btnUpload").onclick = function (ev1) {

               var attachName=document.getElementsByName("attachName")[0].value;
               if(!attachName){
                   alert("资料名称不能为空");
                   return;
               }
               document.forms[0].submit();



            };

        };

    </script>
</head>
<body>
<fmt:setBundle basename="msg" var="bundlel"></fmt:setBundle>
<h2><fmt:message bundle="${bundlel}" key="label.file.upload.title"></fmt:message></h2>

<hr>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
    资料名称：<input type="text" name="attachName"><br>
    资料文件：<input type="file" name="attachFile" multiple><br>
    <input type="button" value='<fmt:message bundle="${bundlel}" key="label.file.upload.btn.upload.text"></fmt:message>' id="btnUpload"><br><br><br>

    <a href="${pageContext.request.contextPath}/file/list">文件列表</a><br><br>
</form>
${msg}
</body>
</html>
