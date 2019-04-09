<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这是登录</title>
	<link rel="stylesheet" href="/js/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="/js/DataTables-1.10.15/media/css/dataTables.bootstrap.min.css"/>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" style="background-color:pink" >
			<h2>飞虎电商后台管理</h2>
		</div>
	</div>
		<form class="form-horizontal">
			<div class="form-group">
				<label for="userName" class="col-sm-2 control-label">账户:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="userName" placeholder="请输入您的账户！！！">
				</div>
			</div>
			<div class="form-group">
				<label for="userPwd" class="col-sm-2 control-label">密码:</label>
				<div class="col-sm-4">
					<input  type="password" id="userPwd" class="form-control"  placeholder="请输入您的密码！！！">
				</div>
			</div>
			<div class="form-group">
				<label for="imgCode" class="col-sm-2 control-label">验证码:</label>
				<div class="col-sm-4">
					<input type="text" id="imgCode">
					<img src="<%=request.getContextPath()%>/imgcode" id="imgCodeInfo">
					<a href="javascrpt:;" onclick="refreshCode();">刷新</a>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" value="登录" onclick="login();"/>
					<td bgcolor="#8a2be2">
						<input type="reset" value="重置"/>
						<a href="<%=request.getContextPath()%>/user/toAddUserInfo.action">注册</a>
					</td>
				</div>
			</div>
		</form>

</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5.js"></script>
<script src="/js/DataTables-1.10.15/jQuery-3.3.1/jquery-3.3.1.min.js"></script>
<script src="/js/DataTables-1.10.15/media/js/jquery.dataTables.min.js"></script>
<script src="/js/DataTables-1.10.15/media/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
		function refreshCode() {
		    //获取当前时间
			var t = new Date().getTime();
			$("#imgCodeInfo").attr("src","<%=request.getContextPath()%>/imgcode?"+t);
		}
		//登录
		function login(){
			var v_userName=$("#userName").val();
			var v_password=hex_md5($("#userPwd").val());
			var v_imgCode=$("#imgCode").val();
			$.ajax({
				type:"post",
				url:"<%=request.getContextPath()%>/user/login.action",
				data:{
				    "userName":v_userName,
					"userPwd":v_password,
					"imgCode":v_imgCode
				},
				dataType:"json",
				success:function(result){
					if(result.code == 200){
						location.href="<%=request.getContextPath()%>/product/tolist.action";
                    }else{
						alert(result.message);
					}
				}
			})
		}
</script>
</html>