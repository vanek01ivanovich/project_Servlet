<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*, java.text.*" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>RailWay</title>
    <link rel="icon" href="data:,">
</head>
<body>
<%--
<form action="${pageContext.request.contextPath}/login" method="post">
    <button>login</button>
</form>--%>

<a href="?lang=en">EN</a>
<a href="?lang=ua">UA</a>
<h2>
    <fmt:message key="login.initial"/>
</h2>

<a type="text/html" href="${pageContext.request.contextPath}/login">login</a>
</body>
</html>
