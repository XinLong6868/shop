<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品列表</title>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/shop/brand.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
</head>
		<table border="1" heigth="200px" align="center">
			<tr>
				<td>标签</td>
				<td><a href="<%=request.getContextPath()%>/product/toAddProduct.action">添加数据</a></td>
			</tr>
			<tr>
				<td>登录人</td>
				<td>尊敬的${userInfo.userName},您好！欢迎登陆！！</td>
			</tr>
			<tr>
				<td>登录次数</td>
				<td>本次登陆次数：${userInfo.loginCount},您好！欢迎登陆！！</td>
			</tr>
				<td>上次登录时间：</td>
				<td>
					<fmt:formatDate value="${userInfo.lastLoginTime}" type="both"/>
				</td>
			</tr>
		</table>
		<form id="productForm">
			<table border="1px" width="700px" cellpadding="0px" cellspacing="0px">
				<tr>
					<td>商品名称:</td>
					<td><input type="text" id="productName" name="productName"/></td>
				</tr>
				<tr>
					<td>武器价格:</td>
					<td><input type="text" id="minprivace" name="minprivace"/>---<input type="text" id="maxprivace" name="maxprivace"/></td>
				</tr>
				<tr>
					<td>武器修改时间:</td>
					<td><input type="text" id="minupdateTime" name="minupdateTime" onClick="WdatePicker({skin:'whyGreen'})"/>---<input type="text" id="maxupdateTime" name="maxupdateTime" onClick="WdatePicker({skin:'whyGreen'})"/></td>
				</tr>
				<tr>
					<td>
						商品类型:
					</td>
					<td>
						<select id="brandSelect" name="brandText.id">
								<option value="-1">==请选择==</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="查询" onclick="search(1);"/>
					</td>
					<td>
						<input type="reset" value="重置"/>
					</td>
				</tr>
			</table>
			<!-- 表格变色并且复选框勾选 -->
			<input type="hidden" id="proIds" />
		</form>
		<input type="button" value="批量删除" onclick="deleteBatchProduct();"/>
		<input type="button" value="导出Excel" onclick="exportExcel();"/>
		<input type="button" value="根据品牌导出Excel" onclick="exportExcelByBrandText();"/>
		<div id="productTableDiv">
		<jsp:include page="/WEB-INF/view/product/productPage.jsp"></jsp:include>
		</div>
</body>
<script type="text/javascript">

    //每页几条
	var v_pageSize;
	function changePageSize(pageSize) {
        v_pageSize = pageSize;
        search(1);
    }
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
			"sortField":v_sortField,
			"sort":v_sort,
			"flag":1,
            "pageSize":v_pageSize},
			success:function(result){
				//刷新
				$("#productTableDiv").html(result);
				initTable();
				initSortButton();
				//给选中的按钮赋值
				if(v_selected_button_id){
					$("input[type='button'][data-button-id='"+v_selected_button_id+"']").css("background","#ccc");
				}
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
		  			//alert(result);
		  			search(1);
		  		},
		  		error:function(result){
		  			alert("是不是删除失败了");
		  		}
			});
		}
		//批量删除
		function deleteBatchProduct(){
			//获取选中的复选框的值
			/* var v_ids="";
			$("input[name='ids']:checkbox:checked").each(function() {
				v_ids += "," + this.value;
			}) */
			if (rowIds.length > 0) {
				/* v_ids = v_ids.substring(1); */
				var v_ids=rowIds.join(",");
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
		
		//下拉框查询ajax
		$(function(){
			initBrandList();
		})
		
		
		
		//声明一个数组
		var rowIds=[];
		//点击选中变色并勾选复选框
		function initTable(){
			
			$("#productTable tbody tr").each(function(){
				//先找到复选框,然后根据name的值选中复选框(后面的0代表下标)
				var v_checkbox=$(this).find("input[name='ids']:checkbox")[0];
				//翻页回填背景色
				for(var i=0;i<rowIds.length;i++){
					if(rowIds[i] == v_checkbox.value){
						$(this).css("background","pink");
						v_checkbox.checked = true;
						break;
					}
				}
				//绑定鼠标移上事件
				$(this).bind('mouseover',function(){
					if(!v_checkbox.checked){
						$(this).css("background","red");
					}
				
						
				})
				//绑定鼠标移下事件
				$(this).bind('mouseout',function(){
						if(!v_checkbox.checked ){
							$(this).css("background","");
						}
					
				})
				//绑定点击事件
				//添加事件,每次点击，console层展示点击的tr
				$(this).bind("click",function(){
					//判断
					if(v_checkbox.checked){
						//取消背景颜色，并且取消勾选	
						$(this).css("background","");
						v_checkbox.checked = false;
						//删除对应数组中的值
						deleteArrTem(v_checkbox.value);
					}else{
						//添加背景颜色，并且勾选复选框
						$(this).css("background","pink");
						v_checkbox.checked = true;
						//将当前选中的复选框的值放入数组中
						rowIds.push(v_checkbox.value);
					}
					//在前台F12 console 查看
					//console.log(v_checkbox);
				});
				
			})
		}
		function deleteArrTem(id){
			//倒着删除
			for(var i=rowIds.length-1;i>=0;i--){
				if(rowIds[i] == id){
					rowIds.splice(i,1);
				}
			}
		}
		//复选框勾选并变色的调用(onReady)
		$(function(){
			initTable();
			//升降序排列
			initSortButton();
		})
		
		//全局变量
		var v_sortField;
		var v_sort;
		//给按钮加标识
		var v_selected_button_id;
		//升降序
		function initSortButton(){
			var i=0;
			$("#productTable thead input[type='button']").each(function(){
				//循环给按钮添加唯一标识
				 $(this).attr("data-button-id",i);
				i++;
				//通过上面的全局变量赋值
				/* if ($(this).attr("data-button-id")==v_selected_button_id) {
					$(this).css("background","blue");
				} */
				//把以前的按钮清空
				 
				
				$(this).bind("click",function(){
					//alert("0000");
					//console.log($(this).attr("data-sort-field"))
					 v_sortField=$(this).attr("data-sort-field");
					 v_sort=$(this).attr("data-sort");
					 //把当前的点击的按钮设置为蓝色
					 $(this).css("background","blue");
					
					 
					//被选中的按钮唯一标识
					v_selected_button_id= $(this).attr("data-button-id");
					
					//调用search
					search(1,v_sortField,v_sort);
				})
				//绑定鼠标移上事件
				$(this).bind('mouseover',function(){
					//通过上面给按钮添加的唯一标识，来判断
					if($(this).attr("data-button-id") == v_selected_button_id){
						return;
					}
						$(this).css("background","red");
				});
				//绑定鼠标移下事件
				
				$(this).bind('mouseout',function(){
					if($(this).attr("data-button-id") == v_selected_button_id){
						return;
					}
						$(this).css("background","");
				});
			})
		}
			//poi导出
			function exportExcel(){
				//用js动态提交form表单，将前台参数传递到后台
				var productForm = document.getElementById("productForm");
				productForm.action="<%=request.getContextPath()%>/product/exportExcel.action";
				productForm.method = "post";
				productForm.submit();
			}
			//poi导出
			function exportExcelByBrandText(){
				//用js动态提交form表单，将前台参数传递到后台
				var productForm = document.getElementById("productForm");
				productForm.action="<%=request.getContextPath()%>/product/exportExcelByBrandText.action";
				productForm.method = "post";
				productForm.submit();
			}
			//查看子图
			/*function findPhotoList(id) {
				location.href="<%=request.getContextPath()%>/photo/findProductList.action?id="+id;
			}*/
			function viewChildImage(productId) {
				location.href="<%=request.getContextPath()%>/photo/findProductList.action?id="+productId;
            }
            function toProductImages(id) {
                $.ajax({
                    "type":"post",
                    "url":"<%=request.getContextPath()%>/bootstrap/product/findProductImages.jhtml?id="+id,
                    success:function(result) {
                        var dialog = bootbox.dialog({
                            title: '查看图片',
                            message: result,
                            size:"large",
                            buttons: {
                                confirm: {
                                    label: '<span class="glyphicon glyphicon-ok"></span>确认',
                                    className: 'btn-primary',
                                    callback: function(){
                                    }
                                },
                                cancel: {
                                    label: '<span class="glyphicon glyphicon-remove"></span>取消',
                                    className: 'btn-danger'
                                }
                            }
                        });
                    }
                })
            }

</script>
</html>