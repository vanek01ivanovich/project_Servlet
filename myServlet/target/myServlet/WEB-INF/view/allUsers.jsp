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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">

</head>
<style>
    <%@include file="/WEB-INF/css/headerFooter.css"%>
    <%@include file="/WEB-INF/css/allstaff.css"%>
</style>
<body>
<header>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="/admin">HOME</a>

        <form action="/logout">
            <button id="logout" type="submit" class="btn btn-outline-warning">logout</button>
        </form>
        <div class="dropdown">
            <button class="btn btn-outline-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Languages
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="?lang=en">English</a>
                <a class="dropdown-item" href="?lang=ua">Ukrainian</a>
            </div>
        </div>
    </nav>
</header>

<table class="table table-striped">
    <thead class="thead-dark">
    <tr>
        <th scope="col">UserName</th>
        <th scope="col">FirstName</th>
        <th scope="col">LAstNAme</th>
        <th scope="col" >Role</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>

        <c:forEach items="${allUsers}" var="users">
            <tr>
                <form action="/admin/allUsers/editUser">
                    <input type="hidden" name="userId" value="${users.getId()}">
                    <th scope="row"> <c:out value="${users.getUserName()}"/></th>
                    <c:if test="${lang == 'en'}">
                        <th scope="row"> <c:out value="${users.getFirstName()}"/></th>
                        <th scope="row"> <c:out value="${users.getLastName()}"/></th>
                    </c:if>
                    <c:if test="${lang == 'ua'}">
                        <th scope="row"> <c:out value="${users.getFirstNameUA()}"/></th>
                        <th scope="row"> <c:out value="${users.getLastNameUA()}"/></th>
                    </c:if>

                    <th scope="row"> <c:out value="${users.getRole()}"/></th>
                    <th><button type="submit">edit</button></th>
                </form>
                <form action="/admin/allUsers" method="post">
                    <input type="hidden" name="userId" value="${users.getId()}">
                    <th scope="row"><button type="submit">delete</button></th>
                </form>

            </tr>
        </c:forEach>
    </tbody>
</table>

<footer class="text-white bg-dark">
    <div id="footer" class="card-footer text-muted text-white bg-dark">© 2020 Copyright:All rights reserved</div>
</footer>

   <%-- <c:forEach items="${allUsers}" var="users">

        <c:out value="${users.getUserName()}"/>
        <form action="/admin/allUsers/editUser">
            <input type="hidden" name="userId" value="${users.getId()}">
            <button type="submit">edit</button>
        </form>
        <form action="/admin/allUsers" method="post">
            <button type="submit">delete</button>
        </form>
        <br>
    </c:forEach>--%>
</body>
</html>
