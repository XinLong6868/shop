<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	
	getData();
	
})
function getData(){
	$.ajax({
		url:"<%=basePath%>findProduct.action",
		data:{},
		type:"post",
		dataType:"json",
		success:function(data){
			$("#totalPage").html(data.totalPage);
			var tableStr = "<tr><th>选择</th><th>序号</th><th>商品名</th><th>价格</th><th>操作</th></tr>"
			for(var i=0;i<data.length;i++){
				var dataStr = "<tr><td><center><input type='checkbox' name='ids' value='"+data[i].id+"'/></center></td><td>"+data[i].id+"</td><td>"+data[i].productName+"</td>"
				+"<td>"+data[i].privace+"</td><td><input type='button' value='删除' onclick='DeleteAjax("+data[i].id+")'/></td></tr>";
				tableStr+=dataStr;
			}
			$("#data_tab").html(tableStr);
			deleateProductAll();
		},
		error:function(err){
			alert("别灰心,再检查一遍!你可以的");
		}	
	});	
} 
		//单个删除
		function DeleteAjax(id){
			$.ajax({
				url:"<%=basePath%>deleateProduct.action",
		  		type:"post",
		  		data:{"id":id},
		  		dataType:"json",
		  		async:true,
		  		success:function(result){
		  			getData();
		  		}, 
		  		error:function(result){
		  			alert("是不是删除失败了");
		  		}
			
			});
		}
		//批量删除
		function deleateProductAll(){
			//获取选中复选框的值
			var v_ids="";
			$("input[name='ids']:checkbox:checked").each(function(){
				v_ids+=","+ this.value;
			})
			
			if(v_ids.length>0){
				v_ids=v_ids.substring(1);
				alert(v_ids)
				//分割
				if(confirm("确认要删除吗?")){
					$.ajax({
						url:"<%=basePath%>deleateProductAll.action",
						type:"post",
						data:{"ids":v_ids},
						success:function(result) {
							
						},
					})
				}
			}else {
				alert("请选择要删除的信息");
			}
		}
</script>
</head>
<body>
		<center><h1><font color="red">路是自己选的<br/>在艰难,跪着也要走完!</font></h1></center>
		<center><h1><font color="red">我在最没有能力的年纪<br/>遇见了最想照顾的人<br/>——颜!</font></h1></center>
		<center>
		<a href="<%=request.getContextPath()%>/product/toAddProduct.action">添加</a><br/>
		<input type="button" value="批量删除" onclick="deleateProductAll();"/>
		</center>
		<table border="1px" width="1000px" cellspacing="0px" align="center" id="data_tab">
		</table>
</body>
</html>