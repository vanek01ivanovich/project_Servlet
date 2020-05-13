<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 05.05.2020
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <link rel="icon" href="data:,">
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<style>
    <%@include file="/WEB-INF/css/ticket.css"%>
    <%@include file="/WEB-INF/css/headerFooter.css"%>
</style>
<body>
<header>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand">Navbar</a>

        <a href="?lang=en">EN</a>
        <a href="?lang=ua">UA</a>
    </nav>
</header>
<form action="/ticket" method="post">

            <input type="hidden" name="idProperty" value="${ticket.getIdProperty()}">
                <p>
                    <c:if test="${lang == 'en'}">
                        <c:forEach items="${ticket.getDestinations()}" var="tick">
                            <c:out value="${tick.getDeparture()}"/>
                        </c:forEach>

                    </c:if>
                    <c:if test="${lang == 'ua'}">
                        <c:forEach items="${ticket.getDestinations()}" var="tick">
                            <c:out value="${tick.getDepartureUA()}"/>
                        </c:forEach>
                    </c:if>

                </p>
                <p>
                    <c:out value="${ticket.getPrice()}"/>
                </p>
                <p>
                    <c:out value="${ticket.getTimeArrival()}"/>
                </p>
                <button type="submit" class="btn btn-outline-primary waves-effect" >Choose</button>



</form>

</body>
</html>
