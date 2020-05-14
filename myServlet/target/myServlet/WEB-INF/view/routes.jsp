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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<style>
    <%@include file="/WEB-INF/css/headerFooter.css"%>
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


    <div class="container" id="content">
        <table class="table">
            <tbody>
                    <c:forEach items="${listRoutes}" var="routes">
                        <tr>
                        <form action="/ticket">


                            <input type="hidden" name="idProperty" value="${routes.getIdProperty()}">
                            <th>
                                <c:if test="${lang == 'en'}">
                                    <c:forEach items="${routes.getDestinations()}" var="destination">
                                        ${destination.getDeparture()}
                                        <br>
                                        <span>Departure</span>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${lang == 'ua'}">
                                    <c:forEach items="${routes.getDestinations()}" var="destination">
                                        ${destination.getDepartureUA()}
                                        <br>
                                        <span>Departure</span>
                                    </c:forEach>
                                </c:if>
                                <br>
                                ${routes.getDateDeparture()}
                                <br>
                                ${routes.getTimeDeparture()}
                            </th>
                            <th>
                                <c:if test="${lang == 'en'}">
                                    <c:forEach items="${routes.getDestinations()}" var="destination">
                                        ${destination.getArrival()}
                                        <br>
                                        <span>Arrival</span>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${lang == 'ua'}">
                                    <c:forEach items="${routes.getDestinations()}" var="destination">
                                        ${destination.getArrivalUA()}
                                        <br>
                                        <span>Arrival</span>
                                    </c:forEach>
                                </c:if>
                                <br>
                                ${routes.getDateArrival()}
                                <br>
                                ${routes.getTimeArrival()}
                            </th>
                            <th>
                                <c:if test="${lang == 'en'}">
                                    <c:forEach items="${routes.getTrains()}" var="destination">
                                        <h5>Train</h5>
                                        ${destination.getTrainName()}
                                    </c:forEach>
                                </c:if>
                                <c:if test="${lang == 'ua'}">
                                    <c:forEach items="${routes.getTrains()}" var="destination">
                                        <h5>Train</h5>
                                        ${destination.getTrainNameUA()}
                                    </c:forEach>
                                </c:if>
                            </th>
                            <th>
                                <h5>Price</h5>
                                ${routes.getPrice()}
                            </th>


                            <th id="button" scope="col"><button type="submit" class="btn btn-outline-primary waves-effect" >Choose</button></th>
                        </form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

<footer class="text-white bg-dark">
    <div id="footer" class="card-footer text-muted text-white bg-dark">© 2020 Copyright:All rights reserved</div>
</footer>

</body>
</html>

<%-- <c:forEach items="${listRoutes}" var="routes">
                    <form action="/ticket">
                    <tr>
                        <input type="hidden" name="idProperty" value="${routes.getIdProperty()}">
                        <c:if test="${lang == 'en'}">
                            <td>${routes.getStationDeparture()}</td>
                            <br>
                            <span>Departure</span>
                            <td>${routes.getStationArrival()}</td>
                        </c:if>
                        <c:if test="${lang == 'ua'}">
                            <td>${routes.getStationDepartureUA()}</td>
                            <td>${routes.getStationArrivalUA()}</td>
                        </c:if>
                        <td>

                                ${routes.getPrice()}
                        </td>
                        <td id="button" scope="col"><button type="submit" class="btn btn-outline-primary waves-effect" >Choose</button></td>
                    </tr>
                    </form>
                </c:forEach>--%>
