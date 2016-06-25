<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
			dataType:"json",
			success : function(data) {
			}
		});
	}
</script>
<title>显示用户列表</title>
</head>
<body>
	<c:forEach items="${userInfoList}" var="map">
	${map.id}
	${map.username}
	${map.password}
	${map.realname}<br>
	</c:forEach>
	<form action="${projectpath}/userInfo/insert" method="post" id="userInfo">
		<table>
			<tr>
				<td>ID:</td>
				<td><input id="id" name="id" type="text" /></td>
			</tr>
			<tr>
				<td>用户名:</td>
				<td><input id="username" name="username" type="text" /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input id="password" name="password" type="password" /></td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input id="realname" name="realname" type="text" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="插入记录1"
					onclick="javascript:insert()"></td>
				<td colspan="2"><input type="submit" value="插入记录2"></td>
			</tr>
		</table>
	</form>
	<a href="${projectpath}/userInfo/delteAll">删除所有用户</a>
</body>
</html>