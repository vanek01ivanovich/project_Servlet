<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 08.05.2020
  Time: 2:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
    <link rel="icon" href="data:,">
</head>
<body>
    <c:forEach items="${allUsers}" var="users">

        <c:out value="${users.getUserName()}"/>
        <form action="/admin/allUsers/editUser">
            <input type="hidden" name="userId" value="${users.getId()}">
            <button type="submit">edit</button>
        </form>
        <form action="/admin/allUsers" method="post">
            <button type="submit">delete</button>
        </form>
        <br>
    </c:forEach>
</body>
</html>
