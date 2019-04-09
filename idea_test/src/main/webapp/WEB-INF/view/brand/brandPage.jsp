<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     <body>
		<table border="1" width="800px" height="200px" cellpadding="0px" cellspacing="0" id="brandTable">
			<tr>
			<td>选择</td>
			<td>编号</td>
			<td>品牌名称</td>
			<td>修改时间</td>
			<td>录入时间</td>
			<td>操作</td>
			</tr>
			<c:forEach items="${findBrand}" var="brandText">
			<tr>
			<td><input type="checkbox" name="ids" value="${brandText.id}"/></td>
			<td>${brandText.id}</td>
			<td data-id="${brandText.id}">${brandText.brandName}</td>
			<td><fmt:formatDate value="${brandText.updateBrandTime}" pattern="yyyy-MM-dd"/></td>
			<td><fmt:formatDate value="${brandText.createBrandTime}" pattern="yyyy-MM-dd"/></td>
			<td>
			<input type="button" value="删除" onclick="deleteBrandID('${brandText.id}')"/>
			<input type="button" value="普通修改" onclick="toUpdateBrand('${brandText.id}')"/>
			<input type="button" value="ajax修改" onclick="editBrandText('${brandText.id}','${brandText.brandName}')"/>
			</td>
			</tr>
			</c:forEach>
</table>
</body>
<jsp:include page="/WEB-INF/common/ajaxpage.jsp"></jsp:include>