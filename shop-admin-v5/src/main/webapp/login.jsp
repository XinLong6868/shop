<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这是登录</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5.js"></script>
</head>
<body>
	<form>
		<table border="1" align="center" heigth="100px">
			<tr>
				<td colspan="2" bgcolor="aqua"><center><h4>欢迎登录！</h4></center></td>
			</tr>
			<tr>
				<td bgcolor="#faebd7">账户:</td>
				<td bgcolor="#faebd7"><input type="text" id="userName"/></td>
			</tr>
			<tr>
				<td bgcolor="#a9a9a9">密码：</td>
				<td bgcolor="#00ff7f"><input type="password" id="userPwd"/></td>
			</tr>
			<tr>
				<td bgcolor="#a52a2a">验证码：</td>
				<td bgcolor="#d2691e">
					<input type="text" id="imgCode"/>
					<img src="<%=request.getContextPath()%>/imgcode" id="imgCodeInfo">
					<a href="javascrpt:;" onclick="refreshCode();">刷新</a>
				</td>
			</tr>
			<tr>
				<td bgcolor="blue">
				<input type="button" value="登录" onclick="login();"/>
				<a href="<%=request.getContextPath()%>/user/toAddUserInfo.action">注册</a>
				</td>
				<td bgcolor="#8a2be2"><input type="reset" value="重置"/></td>
			</tr>
		</table>
	</form>

</body>
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
						location.href="<%=request.getContextPath()%>/product/list.action";
                    }else{
						alert(result.message);
					}
				}
			})
		}
</script>
</html>