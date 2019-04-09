<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.js"></script>
</head>
<body>
		<form action="<%=request.getContextPath()%>/product/updateProduct.action" method="post">
			<input type="hidden" name="id" value="${product.id }"/><br/>
			商品名称:<input type="text" name="productName" value="${product.productName}"/><br/>
			商品价格:<input type="text" name="productprivace" value="${product.productprivace}"/><br/>
			品牌名称
			<select name="brandText.id" id="brandSelect">
					<option value="-1">==请选择==</option>
			</select>
			<input type="submit" value="增加"/>
			<input type="reset" value="取消">
		</form>
</body>
<script type="text/javascript">
//下拉列表框ajax

$(function(){
	initBrandList();
})
function initBrandList(){
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/brand/list.action",
			success:function(result){
				if(result.code == 200){
					var v_brandArr = result.data;
					for(var i = 0; i < v_brandArr.length; i++){
						$("#brandSelect").append("<option value='"+v_brandArr[i].id+"'>"+v_brandArr[i].brandName+"</option>");
					}
					//下拉框回显(通过Id回显)
					$("#brandSelect").val('${product.brandText.id}')
				}
			}
		})
}
</script>
</html>