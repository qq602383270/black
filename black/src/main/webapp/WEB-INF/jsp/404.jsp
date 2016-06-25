<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8" isErrorPage="true"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>404 请求错误</title>  
</head>  
<body>  
 <div class="ui-alert-panel">  
        <h1>访问资源不存在</h1>  
        <p>处理您的请求时发生错误！请确认您通过正确途径操作。</p>  
    </div>  
  
</body>  
</html>  
 --%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="dwr/engine.js"></script>
<%--固定写法--%>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/MyProjectDao.js"></script>
<%--由框架自动生成,文件名根据DWR文件而来--%>
<title>测试</title>
<script type="text/javascript">
	function validate() {
		var name = form1.username.value;
		MyProjectDao.getName("黄东辉", callBack);
		//UserDAOAjax.exitUser(name,show);
<%--exitUser()函数的返回值会赋给show()函数--%>
	}
	function callBack(data) {
		alert("the return value is " + data);
	}

	function getMap() {
		MyProjectDao.getMap(getMapCallBack);
	}
	function getMapCallBack(data) {
		for ( var property in data) {
			alert("property:" + property);
			alert(property + ":" + data[property]);
		}
	}
</script>
</head>
<body onload="validate()">
	<form action="#" name="form1">
		<table id="table1" border="0">
			<tr>
				<td>用户名:<input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密码:<input type="text" name="password" />
				</td>
			</tr>
			<tr>
				<td><input type="button" value="点击" onclick="getMap();" /></td>
			</tr>
		</table>
	</form>
</body>
</html>