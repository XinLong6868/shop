<%--
  Created by IntelliJ IDEA.
  User: 13280
  Date: 2019/2/17
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看子图</title>
</head>
<body>
<c:forEach items="${photoList}" var="photoInfo">
    <div style="width: 20%; float: left">
        <img width="300" height="200" src="<%=request.getContextPath()%>${photoInfo.photoPath}">
    </div>
</c:forEach>
</body>
</html>