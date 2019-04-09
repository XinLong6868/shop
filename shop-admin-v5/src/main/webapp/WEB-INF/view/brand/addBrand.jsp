<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品牌添加</title>
</head>
<body>
		<form action="<%=request.getContextPath()%>/brand/addBrand.action" method="post">
			商品名称:<input type="text" name="brandName"/>
			<input type="submit" value="增加"/>
			<input type="reset" value="取消">
		</form>
</body>
</html>