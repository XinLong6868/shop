$(document).ready(function(){
	var htmlCode = '<table width="60%" border="1px" align="center">'+
						'<tr>'+
							'<td><a onclick="goFirst()">首页</a></td>'+
							'<td><a onclick="goPri()">上一页</a></td>'+
							'<td>第<span id="cpage">1</span>页&nbsp;共<span id="totalPage">0</span>页</td>'+
							'<td><a onclick="goNext()">下一页</a></td>'+
							'<td><a onclick="goLast()">尾页</a></td>'+
							'<td>展示'+
								'<select id="pageSize" onchange="changePageSize()">'+
									'<option value="2">2</option>'+
									'<option value="3">3</option>'+
									'<option value="4">4</option>'+
									'</select>条</td>'+
							'<td><input type="text" id="targetPage" style="width: 60px">'+
								'<input type="button" value="Go" onclick="goToPage()">'+
							'</td>'+
						'</tr>'+
					'</table>'+
					'<center><span id="pager_tips" style="color:red;"></span></center>';
	$("#pager_tools").html(htmlCode);
});

//下一页
function goNext(){
	var cpage = Number($("#cpage").html());
	var totalPage = Number($("#totalPage").html());
	if(cpage + 1 > totalPage){
		$("#pager_tips").html("已经是最后一页");
	}else{
		$("#pager_tips").html("");
		$("#cpage").html(cpage+1);
		getData();
	}
}
//上一页
function goPri(){
	var cpage = Number($("#cpage").html());
	if(cpage - 1 < 1){
		$("#pager_tips").html("已经是第一页");
	}else{
		$("#pager_tips").html("");
		$("#cpage").html(cpage-1);
		getData();
	}
}
//首页
function goFirst(){
	$("#pager_tips").html("");
	$("#cpage").html(1);
	getData();
}

function goLast(){
	$("#pager_tips").html("");
	var totalPage = Number($("#totalPage").html());
	$("#cpage").html(totalPage);
	getData();
}
//改变每页条数
function changePageSize(){
	$("#pager_tips").html("");
	$("#cpage").html(1);
	getData();
}
//指向某页（自定义跳转到哪一页）
function goToPage(){
	var targetPage = Number($("#targetPage").val());
	var totalPage = Number($("#totalPage").html());
	if( targetPage > totalPage){
		targetPage = totalPage;
	}
	$("#pager_tips").html("");
	$("#cpage").html(targetPage);
	$("#targetPage").val(targetPage);
	getData();
}

