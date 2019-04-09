<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5.js"></script>
</head>
<body>
<form>
	<table border="1" align="center">
			<tr>
				<td colspan="2"><center><h4>欢迎来到注册页面!</h4></center></td>
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
				<td><input type="button" value="注册" onclick="register();"/></td>
				<td><input type="reset" value="取消"/></td>
			</tr>
	</table>
</form>
</body>
<script>
    //注册
    function register() {
        var v_userName=$("#userName").val();
        var v_password=hex_md5($("#userPwd").val());
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/user/addUserInfo.action",
            data:{
                "userName":v_userName,
                "userPwd":v_password,
            },
            dataType:"json",
            success:function (result) {
                if (result.code == 200){
                    location.href="<%=request.getContextPath()%>/login.jsp";
                }else {
                    alert(result.message)
                }
            }
        })
    }
</script>
</html>