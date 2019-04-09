<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/shop/brand.js"></script>
</head>
<body>
		<form action="<%=request.getContextPath()%>/product/addProduct.action" method="post" enctype="multipart/form-data">
			<table border="1">
			<tr>
				<td>产品名称:</td>
				<td><input type="text" name="productName"/></td>
			</tr>
			<tr>
				<td>产品价格:</td>
				<td><input type="text" name="productprivace"/></td>
			</tr>
			<tr>
				<td>产品图片:</td>
				<td><input type="file" name="productImage"/></td>
			</tr>
			<tr data-flag="childImageRow">
				<td>产品子图</td>
				<td><input type="file" name="productChildImage"/><input type="button" value="＋" onclick="addChildRow();"></td>
			</tr>
				<tr>
					<td>产品类型:</td>
					<td>
						<select name="brandText.id" id="brandSelect">
						<option value="-1">==请选择==</option>
					</select>
					</td>
				</tr>

				<tr>
					<td>按钮</td>
					<td>
						<input type="submit" value="增加"/>
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
</body>
<script>
//下拉框查询ajax
$(function(){
	initBrandList();
})
/*function fileClickAdd() {
    $("[name='fileName']").last().after("<tr align='center'>" +
        "<td>相关图片</td>" +
        "<td>" +
        "<input type='file' name='photo'><input type='button' value='-' onclick='fileClickDelete(this);'>" +
        "</td>" +
        "</tr>");
}
function fileClickDelete(obj) {
    $(obj).parents("tr").remove();
}*/
function addChildRow() {
	$("tr[data-flag='childImageRow']").last().after('<tr data-flag="childImageRow"><td>产品子图</td><td><input type="file" name="productChildImage"/><input type="button" value="—" onclick="removeRow(this);"></td></tr>')
}
function removeRow(obj) {
	$(obj).parents("tr").remove();
}

</script>

</html>