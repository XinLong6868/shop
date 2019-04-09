<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table border="1" width="1500px" height="400px" cellpadding="0px" cellspacing="0" id="productTable">
	<thead>
	<tr>
		<td>选择</td>
		<td>编号</td>
		<td>商品名称</td>
		<td>商品图片</td>
		<td><input type="button" value="点👆就升(从小到大)" data-sort-field="productprivace" data-sort="asc"/><br/>商品价格<input
				type="button" value="点👇就降(从大到小)" data-sort-field="productprivace" data-sort="desc"/></td>
		<td>品牌名称</td>
		<td><input type="button" value="点👆就升(从小到大)" data-sort-field="updateTime" data-sort="asc"/><br/>修改时间<input
				type="button" value="点👇就降(从大到小)" data-sort-field="updateTime" data-sort="desc"/></td>
		<td><input type="button" value="点👆就升(从小到大)" data-sort-field="createTime" data-sort="asc"/><br/>创建时间<input
				type="button" value="点👇就降(从大到小)" data-sort-field="createTime" data-sort="desc"/></td>
		<td>操作</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${findProduct}" var="product">
		<tr>
			<td><input type="checkbox" name="ids" value="${product.id}"/></td>
			<td>${product.id}</td>
			<td>${product.productName}</td>
			<td><img src="<%=request.getContextPath()%>${product.productImagePath}" width="100px" height="50px"/></td>
			<td>${product.productprivace}</td>
			<td>${product.brandText.brandName}</td>
			<td><fmt:formatDate value="${product.updateTime}" pattern="yyyy-MM-dd"/></td>
			<td><fmt:formatDate value="${product.createTime}" pattern="yyyy-MM-dd"/></td>
			<td>
				<input type="button" value="删除" onclick="deleteAjax('${product.id}')"/>
				<input type="button" value="修改" onclick="toUpdateProduct('${product.id }')"/>
				<input type="button" value="查看子图片" onclick="viewChildImage('${product.id}')">
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<jsp:include page="/WEB-INF/common/ajaxpage.jsp"></jsp:include>