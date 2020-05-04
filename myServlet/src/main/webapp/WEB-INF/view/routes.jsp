<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 27.04.2020
  Time: 21:32
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
    <%@include file="/WEB-INF/css/routes.css"%>
</style>
<body>
<header>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="/user">Navbar</a>



        <form action="/findroute" id="buttonRoutes">
            <button type="submit">Find another routes</button>
        </form>
        <a href="?lang=en">EN</a>
        <a href="?lang=ua">UA</a>


    </nav>

</header>


    <div id="content">
        <table class="table">
            <thead>
                <tr>
                    <th>From</th>
                    <th>To</th>
                    <th>Price</th>

                </tr>
            </thead>
            <tbody>

                <c:forEach items="${listRoutes}" var="routes">
                    <form>
                    <tr>
                        <c:if test="${lang == 'en'}">
                            <td>${routes.getStationDeparture()}</td>
                            <td>${routes.getStationArrival()}</td>
                        </c:if>
                        <c:if test="${lang == 'ua'}">
                            <td>${routes.getStationDepartureUA()}</td>
                            <td>${routes.getStationArrivalUA()}</td>
                        </c:if>
                        <td>${routes.getPrice()}</td>
                        <td id="button" scope="col"><button type="submit" class="btn btn-outline-primary waves-effect" >Choose</button></td>
                    </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
