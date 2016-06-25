<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
	function insert() {
		$("#id").val(parseInt($("#id").val()) + 1);
		var arrays = $("#userInfo").serializeArray();
		$.ajax({
			url : "${projectpath}/userInfo/insert",
			data : arrays,
			dataType : "json",
			success : function(data) {
			}
		});
	}
</script>
<title>用户登录</title>
</head>
<body>
	<form action="${projectpath}/userInfo/userLogin" method="post"
		id="userInfo">
		<table>

			<tr>
				<td>用户名:</td>
				<td><input id="username" name="username" type="text" /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input id="password" name="password" type="password" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="登陆"></td>
			</tr>
		</table>
	</form>
</body>
</html>