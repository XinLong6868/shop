/*异步加载品牌信息  */
 function initBrandList(selectElement,brandId){
	 $.ajax({
			url:contextPath+"/brand/findBrandList.jhtml",

			//dataType:"json",
			data:{},
			type:"post",
			async:true,
			success:function(res){
				if(res.code==200){
					var brandArr=res.data;
					for(var i=0;i<brandArr.length;i++){
						$("select[name='"+selectElement+"']").append("<option value='"+brandArr[i].id+"'>"+brandArr[i].brandName+"</option>");
					}
					if(brandId){
						$("select[name='"+selectElement+"']").val(brandId);
					}
				}else{
					alert(res.msg);
				}
			}
		})
}
 