<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
         <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品牌展示</title>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
</head>
     <body>
		<form>
			<table border="1px" width="700px" cellpadding="0px" cellspacing="0px">
			<tr>
			<td>品牌名称:</td>
			<td><input type="text" id="brandName"/></td>
			</tr>
			<tr>
			<td>录入时间:</td>
			<td><input type="text" id="mincreateBrandTime" onClick="WdatePicker({skin:'whyGreen'})"/>---<input type="text" id="maxcreateBrandTime" onClick="WdatePicker({skin:'whyGreen'})"/></td>
			</tr>
			<tr>
			<td><input type="button" value="查询" onclick="searchBrand(1);"/></td>
			<td><input type="reset" value="重置"/></td>
			</tr>
			</table>
			<!-- 表格变色并且复选框勾选 -->
			<input type="hidden" id="proIds" />
		</form>
		<input type="text" id="addBrandName"/><input type="button" value="增加" onclick="addbrand();"/>
		<a href="<%=request.getContextPath()%>/brand/toAddBrand.action">添加</a><br/>
		<input type="button" value="批量删除" onclick="deleteBatchBrand();"/>
		<div id="btandTextTableDiv">
		<jsp:include page="/WEB-INF/view/brand/brandPage.jsp"></jsp:include>
		</div>
<script type="text/javascript">
		$(function(){
			brandTable();
		})
		//分页条件查询
		function searchBrand(page){
			var brandName=$("#brandName").val();
			var mincreateBrandTime=$("#mincreateBrandTime").val();
			var maxcreateBrandTime=$("#maxcreateBrandTime").val();
			$.ajax({
				url:"<%=request.getContextPath()%>/brand/listBrand.action",
				type:"post",
				data:{
					"brandName":brandName,
					"pageIndex":page,
					"mincreateBrandTime":mincreateBrandTime,
					"maxcreateBrandTime":maxcreateBrandTime,
					"flag":1},
					success:function(result){
						//刷新
						$("#btandTextTableDiv").html(result);
						brandTable();
						initCheckbox();
					}
			})
		}
		function turnPage(pageIndex) {
			searchBrand(pageIndex);
		}
		//单个删除
		function deleteBrandID(id){
			$.ajax({
				url:"<%=basePath%>deleteBrandID.action",
		  		type:"post",
		  		data:{"id":id},
		  		dataType:"json",
		  		async:true,
		  		success:function(result){
		  			alert(result);
		  			searchBrand(1);
		  		},
		  		error:function(result){
		  			alert("是不是删除失败了");
		  		}
			});
		}
			//回填
			function toUpdateBrand(id){
				location.href="<%=request.getContextPath()%>/findbrand.action?id="+id;
			}

			/* 选择表格变色 */
			function brandTable(){
				//获取表格
				var st = $("#brandTable").get(0);
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
			//批量删除
			function deleteBatchBrand(){
				//获取选中的复选框的值
				var v_ids="";
				$("input[name='ids']:checkbox:checked").each(function() {
					v_ids += "," + this.value;
				})
				if (v_ids.length > 0) {
					v_ids = v_ids.substring(1);
					if (confirm("确认要删除吗")) {
						$.ajax({
							url:"<%=request.getContextPath()%>/deleteBatchBrand.action",
							type:"post",
							data:{"ids":v_ids},
							success:function(result) {
								searchBrand(1);
							}
						})
					}
				} else {
					alert("请选择要删除的信息");
				}
			}
			
			//ajax增加
			function addbrand(){
				var v_brandName= $("#addBrandName").val();
				//插入数据
				 $.ajax({
					 type:"post",
					 url:"<%=request.getContextPath()%>/brand/addBrand.action",
					 data:{"brandName":v_brandName},
					 success:function(result){
						 if(result.code == 200){
							//刷新页面
							searchBrand(1);
						 }
					 }
				 })
				
			}
			//单页面修改通过拼接的形式
			function editBrandText(brandTextId,brandName){
				$("td[data-id='"+brandTextId+"']").html("<input type='text' value='"+brandName+"' id='updateBrandName_"+brandTextId+"'/><input type='button' value='保存' onclick='saveBrand(\""+brandTextId+"\");'/><input type='button' value='取消' onclick='cancel(\""+brandTextId+"\",\""+brandName+"\");'/>");
			}
			//单页面取消修改
			function cancel(brandTextId,brandName){
				$("td[data-id='"+brandTextId+"']").html(brandName);
			}
			
			function saveBrand(brandTextId){
				var v_brandName = $("#updateBrandName_"+brandTextId).val();
				//console.log(v_brandName);
				$.ajax({
					type:"post",
					url:"<%=request.getContextPath()%>/brand/updateBrandText.action",
					data:{
						"id":brandTextId,"brandName":v_brandName
					},
					success:function(result){
						if(result.code == 200){
							$("td[data-id='"+brandTextId+"']").html(v_brandName);
							//刷新页面
							searchBrand(1);
						}
					}
				})
			}
</script>
</html>