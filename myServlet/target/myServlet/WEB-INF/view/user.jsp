<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 15.04.2020
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1>
    <fmt:message key="user.hi"/>
</h1>
<a href="/logout">logout</a>
<a href="/findroute">Find Route</a>

</body>

</html>
