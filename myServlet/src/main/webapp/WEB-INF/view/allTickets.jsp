<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 08.05.2020
  Time: 19:50
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<style>
    <%@include file="/WEB-INF/css/headerFooter.css"%>
    <%@include file="/WEB-INF/css/tables.css"%>
    <%@include file="/WEB-INF/css/allstaff.css"%>
</style>
<body>
<header>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="/admin">Navbar</a>
        <a href="?lang=en">EN</a>
        <a href="?lang=ua">UA</a>
    </nav>

</header>
<table class="table table-striped">
    <thead class="thead-dark">
   <%-- <tr>
        <th scope="col" th:text="#{admin.all.ticket.first.name}"></th>
        <th scope="col" th:text="#{admin.all.ticket.last.name}"></th>
        <th scope="col" th:text="#{admin.all.tickets.station.from}"></th>
        <th scope="col" th:text="#{admin.all.tickets.station.to}"></th>
        <th scope="col" th:text="#{admin.all.tickets.train.name}"></th>
        <th scope="col" th:text="#{admin.all.tickets.price}"></th>
        <th scope="col" th:text="#{admin.all.tickets.date.departure}"></th>
        <th scope="col" th:text="#{admin.all.tickets.date.arrival}"></th>
        <th scope="col" th:text="#{admin.all.tickets.time.departure}"></th>
        <th scope="col" th:text="#{admin.all.tickets.time.arrival}"></th>
    </tr>--%>
    </thead>
</table>




    <c:forEach items="${allTickets}" var="tickets">
        <c:out value="${tickets.getFirstName()}"/>
        <c:forEach items="${tickets.getDestinationProperties()}" var="dest">
            <c:out value="${dest.getPrice()}"/>
        </c:forEach>
        <br>
    </c:forEach>
</body>
</html>
