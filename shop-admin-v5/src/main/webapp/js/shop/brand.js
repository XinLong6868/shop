	function initBrandList(idbrand){
				$.ajax({
					type:"post",
					url:"/brand/list.action",
					success:function(result){
						if(result.code == 200){
							var v_brandArr = result.data;
							for(var i = 0; i < v_brandArr.length; i++){
								$("#brandSelect").append("<option value='"+v_brandArr[i].id+"'>"+v_brandArr[i].brandName+"</option>");
							}
							//下拉框回显(通过Id回显)
							$("#brandSelect").val(idbrand)
						}
					}
				})
		}