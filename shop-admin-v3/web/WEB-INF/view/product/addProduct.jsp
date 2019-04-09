<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="<%=request.getContextPath()%>/product/addProduct.action" method="post">
				商品名称:<input type="text" name="productName"/>
				商品价格:<input type="text" name="productPrivace"/>
				<input type="submit" value="增加"/>
				<input type="reset" value="取消">
		</form>
</body>
</html>