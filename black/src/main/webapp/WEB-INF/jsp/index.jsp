<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="index.test" /></title>
</head>
<body>
	<h1>this is jsp page</h1>
	<c:forEach items="${listMap}" var="map">
	${map.id}
	${map.username}
	${map.password}
	${map.realname}<br>
	</c:forEach>
	${initParam.contextConfigLocation} <h1>${initParam}</h1><br><br>
	<c:forEach items="${userInfoList}" var="map">
	${map.id}
	${map.username}
	${map.password}
	${map.realname}<br>
	</c:forEach>
	<spring:message code="index.test" />
	<a href="${projectpath}/userInfo/getAllUserInfo" >显示所有用户</a>
</body>
</html>