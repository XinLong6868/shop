<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改品牌</title>
</head>
<body>
		<form action="<%=request.getContextPath()%>/brand/updateBrandText.action" method="post">
			<input type="hidden" name="id" value="${brandText.id}"/>
			品牌名称:<input type="text" name="brandName" value="${brandText.brandName}"/>
			<input type="submit" value="增加"/>
			<input type="reset" value="取消">
		</form>
</body>
</html>