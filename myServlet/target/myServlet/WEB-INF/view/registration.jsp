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
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <title>Title</title>
    <link rel="icon" href="data:,">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<style>
    <%@include file="/WEB-INF/css/headerFooter.css"%>
    <%@include file="/WEB-INF/css/registration.css"%>
</style>
<body>
<header>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="/login">HOME</a>
        <div class="dropdown">
            <button class="btn btn-outline-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <fmt:message key="languages"/>
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="?lang=en"><fmt:message key="english"/></a>
                <a class="dropdown-item" href="?lang=ua"><fmt:message key="ukrainian"/></a>
            </div>
        </div>
    </nav>
</header>

<input type="hidden" value="${alert}" id="button">
<div class="container card text-center">
    <div class="card-header">
        <fmt:message key="registration"/>
    </div>
    <div class="row">
        <div class="col-sm ">
            <form method="post" id="formStyle">
                <div class="card-body">
                    <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><fmt:message key="user.name"/></span>
                            </div>
                            <input name="userName" type="text" class="form-control" id="validationServerUsername" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                    </div>
                    <c:if test="${validUserName == false}">
                        <div class="alert alert-danger" role="alert">
                            user LOL
                        </div>
                    </c:if>

                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><fmt:message key="first.name"/></span>
                        </div>
                        <input name="firstName" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                    </div>
                    <c:if test="${validFirstName == false}">
                        <div class="alert alert-danger" role="alert">
                            firstName LOL
                        </div>
                    </c:if>




                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><fmt:message key="last.name"/></span>
                        </div>
                        <input name="lastName" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                    </div>
                        <c:if test="${validLastName == false}">
                            <div class="alert alert-danger" role="alert">
                                lastName LOL
                            </div>
                        </c:if>

                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><fmt:message key="ukr.first.name"/></span>
                        </div>
                        <input name="ukrFirstName" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                    </div>
                        <c:if test="${validFirstNameUkr == false}">
                            <div class="alert alert-danger" role="alert">
                                firtstNAme ukr LOL
                            </div>
                        </c:if>


                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><fmt:message key="ukr.last.name"/></span>
                        </div>
                        <input name="ukrLastName" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                    </div>
                        <c:if test="${validLastNameUkr == false}">
                            <div class="alert alert-danger" role="alert">
                                lastName ukr LOL
                            </div>
                        </c:if>


                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><fmt:message key="password"/></span>
                        </div>
                        <input name="password" type="password" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                    </div>
                </div>

                <button type="submit"><fmt:message key="sign.in"/></button>
            </form>

        </div>

    </div>

</div>
<form action="/login">
    <button type="submit"><fmt:message key="back"/></button>
</form>

<footer class="text-white bg-dark">
    <div id="footer" class="card-footer text-muted text-white bg-dark"><fmt:message key="footer"/></div>
</footer>

<script>
    var al = document.getElementById("button").value;

    if (al === "1"){
        swal({
            icon:"error",
            text:"Regex"
        });
    }

    if (al === "0"){
        swal({
            icon:"error",
            text:"exist"
        });
    }
</script>
</body>
</html>
