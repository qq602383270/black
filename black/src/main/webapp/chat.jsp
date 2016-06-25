<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@include file="WEB-INF/include/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Chat</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<script type="text/javascript" src="${pageContext.request.contextPath }/dwr/engine.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/dwr/util.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/dwr/interface/ChatService.js"></script>
<script type="text/javascript">
	function send() {
		var time = new Date();
		var content = dwr.util.getValue("content");
		var name = dwr.util.getValue("userName");
		var info = encodeURI(encodeURI(name + " :\n" + content));
		var msg = {
			"msg" : info,
			"time" : time
		};
		dwr.util.setValue("content", "");
		if (!!content) {
			ChatService.sendMessage(msg);
		} else {
			alert("发送的内容不能为空！");
		}
	}

	function showMessage(data) {
		var message = decodeURI(decodeURI(data.msg));
		var text = dwr.util.getValue("info");
		if (!!text) {
			dwr.util.setValue("info", text + "\n" + data.time + "  " + message);
		} else {
			dwr.util.setValue("info", data.time + "  " + message);
		}
	}
</script>
</head>

<body onload="dwr.engine.setActiveReverseAjax(true);">
	<div class="doc-content">
		<div class="row">
			<div class="span18">
				<div class="panel panel-primary" >
					<div class="panel-header clearfix">
						<h3 class="pull-left">对话框</h3>
					</div>
					<div class="panel-body" style="height: 300px">
						<textarea id="info" class="textarea" style="height:95% ;width: 95%;resize: none;" readonly="readonly"></textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr />
	昵称：
	<input type="text" id="userName" />
	<br /> 消息：
	<textarea rows="5" cols="60" id="content"></textarea>
	<br /> <input type="button" value=" Send " onclick="send()"  />
</body>
</html>