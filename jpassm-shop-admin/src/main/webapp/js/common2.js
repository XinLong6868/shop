$(document).ready(function(){
	var htmlCode ='<div class="message">共<i class="blue" id="totalPage">0</i>页每页展示'+
						'<select id="pageSize" onchange="changePageSize()">'+
							'<option value="2">2</option>'+
							'<option value="3">3</option>'+
							'<option value="4">4</option>'+
						'</select>条'+
					'</div>'+
					'<ul class="paginList">'+
						'<li class="paginItem"><a onclick="goPri()"><span class="pagepre"></span></a></li>'+
						'<li class="paginItem"><a onclick="goToPageOne(1)" id="cpage">1</a></li>'+
						'<li class="paginItem"><a onclick="goNext()"><span class="pagenxt"></span></a></li>'+
					'</ul>';
	$("#pagin").html(htmlCode);
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
	   	//展示
		function changePageSize(){
			$("#pager_tips").html("");
			$("#cpage").html(1);
		getData();
		}


