<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
		<center><h1><font color="red">不努力,你凭什么<br/>自己选的道路,在艰难,跪着也要走完!<br/>-加油！</font></h1></center>
		<center><h1><font color="red">我在最没有能力的年纪<br/>遇见了最想照顾的人<br/>——颜!</font></h1></center>
		<a href="<%=request.getContextPath()%>/product/toAddProduct.action">添加</a><br/>
		<form>
			<table border="1px" width="700px" cellpadding="0px" cellspacing="0px">
			<tr>
			<td>商品名称:</td>
			<td><input type="text" id="productName"/></td>
			</tr>
			<tr>
			<td>武器价格:</td>
			<td><input type="text" id="minprivace"/>---<input type="text" id="maxprivace"/></td>
			</tr>
			<tr>
			<td>武器修改时间:</td>
			<td><input type="text" id="minupdateTime" onClick="WdatePicker({skin:'whyGreen'})"/>---<input type="text" id="maxupdateTime" onClick="WdatePicker({skin:'whyGreen'})"/></td>
			</tr>
			<tr>
			<td>
			商品类型:
			</td>
			<td>
			<select id="brandSelect">
					<option value="-1">==请选择==</option>
			</select>
			</td> 
			</tr>
			<tr>
			<td><input type="button" value="查询" onclick="search(1);"/></td>
			<td><input type="reset" value="重置"/></td>
			</tr>
			</table>
			<!-- 表格变色并且复选框勾选 -->
			<input type="hidden" id="proIds" />
		</form>
		<input type="button" value="批量删除" onclick="deleteBatchProduct();"/>
		
		<div id="productTableDiv">
		<jsp:include page="/WEB-INF/view/product/productPage.jsp"></jsp:include>
		</div>
		
</body>
<script type="text/javascript">
$(function(){
	productTable();
})
//分页条件查询
function search(page){
	var productName=$("#productName").val();
	var minprivace=$("#minprivace").val();
	var maxprivace=$("#maxprivace").val();
	var minupdateTime=$("#minupdateTime").val();
	var maxupdateTime=$("#maxupdateTime").val();
	var v_brandId=$("#brandSelect").val();
	$.ajax({
		url:"<%=request.getContextPath()%>/product/list.action",
		type:"post",
		data:{
			"productName":productName,
			"minprivace":minprivace,
			"maxprivace":maxprivace,
			"minupdateTime":minupdateTime,
			"maxupdateTime":maxupdateTime,
			"pageIndex":page,
			"brandText.id":v_brandId,
			"flag":1},
			success:function(result){
				//刷新
				$("#productTableDiv").html(result);
				productTable();
				initCheckbox();
			}
	})
}
function turnPage(pageIndex) {
	search(pageIndex);
}
//单个删除
		function deleteAjax(id){
			$.ajax({
				url:"<%=basePath%>deleteProductID.action",
		  		type:"post",
		  		data:{"id":id},
		  		dataType:"json",
		  		async:true,
		  		success:function(result){
		  			//后台响应给前台数据
		  			alert("result:"+result);
		  			console.log(result);
		  			if(result.code == 200){
		  				search(1);
		  			}else{
		  				alert(result.msg);
		  			}
		  			
		  		},
		  		error:function(result){
		  			alert("是不是删除失败了");
		  		}
			});
		}
		//批量删除
		function deleteBatchProduct(){
			//获取选中的复选框的值
			var v_ids="";
			$("input[name='ids']:checkbox:checked").each(function() {
				v_ids += "," + this.value;
			})
			if (v_ids.length > 0) {
				v_ids = v_ids.substring(1);
				if (confirm("确认要删除吗")) {
					$.ajax({
						url:"<%=request.getContextPath()%>/deleteBatchProduct.action",
						type:"post",
						data:{"ids":v_ids},
						success:function(result) {
							search(1);
						}
					})
				}
			} else {
				alert("请选择要删除的信息");
			}
		}
		//回填
		function toUpdateProduct(id){
			location.href="<%=request.getContextPath()%>/findproduct.action?id="+id;
		}
		
		/* 选择表格变色 */
		function productTable(){
			//获取表格
			var st = $("#productTable").get(0);
			//获取表格的所有行
			var trs = st.rows;
			//遍历表格所有行
			for(var i = 0; i<trs.length; i++){
				//鼠标点击事件
				trs[i].onclick=function(){
					if(this.style.backgroundColor!="pink"){
						this.style.backgroundColor="pink";
						//在tr的基础上找到复选框					
						var checkbox = $(this).children().children();
						checkbox.prop({"checked":true});
						$("#proIds").val(checkbox.val()+","+$("#proIds").val());
					}else{
						this.style.backgroundColor="";
						var checkbox = $(this).children().children();
						checkbox.prop({"checked":false});
						var ids = $("#proIds").val();
						ids = ids.replace(checkbox.val()+",","");
						$("#proIds").val(ids);
					}
				}
			}
		}
		
		/* 初始化表格 */
		function initCheckbox() {
			var ids = $("#proIds").val().split(",");
			for (var i = 0; i < ids.length; i++) {
				$("input[name='ids']").each(function(){
					if (ids[i]==$(this).val()) {
						 $(this).prop({"checked":true});
						 var tr = $(this).parent().parent();
						 tr.get(0).style.backgroundColor="pink";
					}
				})
			}
		}
		
		
		//查询下拉列表框ajax
		
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
						}
					}
				})
}
 
</script>

</html>