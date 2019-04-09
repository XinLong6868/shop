<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="<%=request.getContextPath()%>/product/updateProduct.action" method="post">
			<input type="hidden" name="id" value="${product.id }"/><br/>
			商品名称:<input type="text" name="productName" value="${product.productName}"/><br/>
			商品价格:<input type="text" name="productprivace" value="${product.productprivace}"/><br/>
			品牌名称
			<select name="brandText.id">
					<option value="-1">==请选择==</option>
					<c:forEach items="${branList}" var="brand">
					<option value="${brand.id}" ${product.brandText.id==brand.id?"selected":""}>==${brand.brandName}==</option>
					</c:forEach>
			</select>
			<input type="submit" value="增加"/>
			<input type="reset" value="取消">
		</form>
</body>
</html>