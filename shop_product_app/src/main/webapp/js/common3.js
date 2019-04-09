
 $(document).ready(function(){
	var htmlCode ='<div class="message">共<i class="blue" id="totalPage1">0</i>页每页展示'+
						'<select id="pageSize1" onchange="changePageSize1()">'+
							'<option value="2">2</option>'+
							'<option value="3">3</option>'+
							'<option value="4">4</option>'+
						'</select>条'+
					'</div>'+
					'<ul class="paginList">'+
						'<li class="paginItem"><a onclick="goPri1()"><span class="pagepre"></span></a></li>'+
						'<li class="paginItem"><a onclick="goToPageOne1(1)" id="cpage1">1</a></li>'+
						'<li class="paginItem"><a onclick="goNext1()"><span class="pagenxt"></span></a></li>'+
					'</ul>';
	$("#pagin1").html(htmlCode);
});

//下一页
		function goNext1(){
			var cpage1 = Number($("#cpage1").html());
			var totalPage1 = Number($("#totalPage1").html());
			if(cpage1 + 1 > totalPage1){
				$("#pager_tips1").html("已经是最后一页");
			}else{
				$("#pager_tips1").html("");
				$("#cpage1").html(cpage1+1);
				getDataMovie();
			}
		}
		//上一页
		function goPri1(){
			var cpage1 = Number($("#cpage1").html());
			if(cpage1 - 1 < 1){
				$("#pager_tips1").html("已经是第一页");
			}else{
				$("#pager_tips1").html("");
				$("#cpage1").html(cpage1-1);
				getDataMovie();
			}
		}
	   	//展示
		function changePageSize1(){
			$("#pager_tips1").html("");
			$("#cpage1").html(1);
			getDataMovie();
		} 