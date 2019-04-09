
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看子图</title>
    <link rel="stylesheet" href="/js/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach items="${photoList}" var="photoInfo">
            <div class="col-md-4 col-md-6">
                <img width="800px" height="400px" src="<%=request.getContextPath()%>${photoInfo.photoPath}">
            </div>
        </c:forEach>
    </div>

</div>
</body>