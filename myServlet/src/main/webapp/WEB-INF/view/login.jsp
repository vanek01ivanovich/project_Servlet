<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 15.04.2020
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Title</title>
    <link rel="icon" href="data:,">
</head>
<body>
<div style="text-align: center">
    <h2>
        <fmt:message key="login.initial"/>
    </h2>
    <a href="?lang=en">EN</a>
    <a href="?lang=ua">UA</a>

    <h1>Admin Login</h1>
    <form method="post">
        <label>UserName:
            <input name="userName">
       </label>
        <br><br>
        <label >Password:
            <input type="password" name="password">
        </label>

        <br><br>
        <button type="submit">Login</button>
    </form>
    <form action="/registration">
        <button type="submit">Registration</button>
    </form>
</div>
</body>
</html>
