<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     
	<table border="1" width="800px" height="200px" cellpadding="0px" cellspacing="0" id="productTable">
			<tr>
			<td>选择</td>
			<td>编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>品牌名称</td>
			<td>修改时间</td>
			<td>创建时间</td>
			<td>操作</td>
			</tr>
			<c:forEach items="${findProduct}" var="product">
			<tr>
			<td><input type="checkbox" name="ids" value="${product.id}"/></td>
			<td>${product.id}</td>
			<td>${product.productName}</td>
			<td>${product.productprivace}</td>
			<td>${product.brandText.brandName}</td>
			<td><fmt:formatDate value="${product.updateTime}" pattern="yyyy-MM-dd"/></td>
			<td><fmt:formatDate value="${product.createTime}" pattern="yyyy-MM-dd"/></td>
			<td>
			<input type="button" value="删除" onclick="deleteAjax('${product.id}')"/>
			<input type="button" value="修改" onclick="toUpdateProduct('${product.id }')"/>
			</td>
			</tr>
			</c:forEach>
</table>


<jsp:include page="/WEB-INF/common/ajaxpage.jsp"></jsp:include>