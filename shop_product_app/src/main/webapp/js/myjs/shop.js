/*异步加载品牌信息  */
 function initBrandList(selectElement){
	 $.ajax({
			url:contextPath+"/app/findBrandList.jhtml",
			data:{},
			type:"post",
			async:true,
			success:function(res){
				if(res.code==200){
					var brandArr=res.data;
					for(var i=0;i<brandArr.length;i++){
						$("select[name='"+selectElement+"']").append("<option value='"+brandArr[i].id+"'>"+brandArr[i].brandName+"</option>");
					}
				}else{
					alert(res.msg);
				}
			}
		})
}
 