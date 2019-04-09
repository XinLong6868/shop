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
		<form action="<%=request.getContextPath()%>/product/updateProduct.action" method="post" enctype="multipart/form-data">
			<table border="1">
			<input type="hidden" name="id" value="${product.id }"/><br/>
				<tr>
					<td>产品名称:</td>
					<td><input type="text" name="productName" value="${product.productName}"/></td>
				</tr>
				<tr>
					<td>产品图片:</td>
					<td>
						<img src="<%=request.getContextPath()%>${product.productImagePath}" width="50px" height="50px"/>
						<input type="file" name="productImage"/>
						<%--对应的图片相对路径--%>
						<input type="hidden" name="productImagePath" value="${product.productImagePath}"/>
					</td>
				</tr>
				<tr>
					<td>产品子图图片:</td>
					<td>
						<c:forEach items="${photoList}" var="photoInfo">

							<span>
								<input type="button" data-imageId="${photoInfo.id}" data-imagePath="${photoInfo.photoPath}"
									   value="删除" onclick="deleteChildFromPage(this)"/>
								<img width="300" height="200" src="<%=request.getContextPath()%>${photoInfo.photoPath}">
							</span>
						</c:forEach>
					</td>
				</tr>
				<tr data-flag="childImageRow">
					<td>产品子图</td>
					<td>
						<input type="file" name="productChildImage"/>
						<input type="button" value="＋" onclick="addChildRow();">

					</td>
				</tr>
				<tr>
					<td>产品价格:</td>
					<td><input type="text" name="productprivace" value="${product.productprivace}"/></td>
				</tr>
				<tr>
					<td>产品品牌:</td>
					<td>
						<select name="brandText.id" id="brandSelect">
							<option value="-1">==请选择==</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="增加"/></td>
					<td>
						<input type="reset" value="取消">
					</td>
				</tr>

			</table>
			<%--测试用    name用来传值--%>
			<input type="text" id="lookIds" name="lookIds"/>
			<input type="text" id="lookPaths" name="lookPaths"/>
		</form>
</body>
<script type="text/javascript">
//下拉框查询ajax
$(function(){
	initBrandList('${product.brandText.id}');
})


function addChildRow() {
    $("tr[data-flag='childImageRow']").last().after('<tr data-flag="childImageRow"><td>产品子图</td>' +
        '<td><input type="file" name="productChildImage"/><input type="button" value="—" onclick="removeRow(this);"></td></tr>')
}


function removeRow(obj) {
    $(obj).parents("tr").remove();
}

/*页面上的移出，这个是假删除，只是页面上不显示*/
var imageIds=[];
var imagePaths=[];
function deleteChildFromPage(obj){

    var imageId=$(obj).attr("data-imageId");
    alert(imageId);

    var imagePath=$(obj).attr("data-imagePath");
    alert(imagePath);

    /*用push方法，将页面上已经移出的照片传到后台，真正的删掉*/
    imageIds.push(imageId);
    imagePaths.push(imagePath);

    if(imageIds!=null){
        if(confirm("确定要删除吗？")){
            $(obj).parent().remove();
        }
    }
    /*将数组中的值放入input框，传到后台*/
    $("#lookIds").val(imageIds);
    $("#lookPaths").val(imagePaths);
}

</script>
</html>