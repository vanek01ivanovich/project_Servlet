<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 19.04.2020
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
    <link rel="icon" href="data:,">
</head>
<body>

    <form method="post">
        <label>
            User Name:
            <input type="text" name="userName">
        </label>
        <br>
        <label>
            First Name:
            <input type="text" name="firstName">
            <c:if test="${sessionScope.invalidMes == true}">
                LOL
            </c:if>
        </label>
        <br>
        <label>
            Last Name:
            <input type="text" name="lastName">
        </label>
        <br>
        <label>
            Password:
            <input type="password" name="password">
        </label>
        <br>
        <button type="submit">Sign in</button>
    </form>
    <form action="/login">
        <button type="submit">Back to login</button>
    </form>

</body>
</html>
