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
<title>用户登录</title>
</head>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.2.js"></script>
<body>
<div style="width:100%;text-align:center">
    <h1>用户登录</h1>
    <form action="<%=request.getContextPath() %>/user/loginUserInfo.action"  method="post">
        <font color="red"><span>${msg1}</span><br></font>
        姓名: <input type="text" name="userName" ><br>
        <font color="red"><span>${msg2}</span><br></font>
        密码: <input type="text" name="userPwd"><br/>
        <input type="submit" value="登录">
        <input type="reset" value="重置">
        <input type="button" value="注册" onclick="addUserInfo()">
        <br>
    </form>
</div>
<div id="addUserInfoLog">
		<form action="<%=request.getContextPath()%>/user/addUserInfo.action" method="post">
			账号:<input type="text" name="userName"/><br/>
			密码:<input type="text" name="userPwd"/><br/>
			<input type="submit" value="提交"/>
			<input type="reset" value="重置"/>
		</form>
</div>
</body>
<script type="text/javascript">
//ajax添加
function addUserInfo(){
	$.ajax({
		url:"<%=basePath%>/user/toAddUserInfo.action",
		type:"post",
		success:function(result){
			$("#addUserInfoLog").html(result);
		}
	})
}
</script>
</html>