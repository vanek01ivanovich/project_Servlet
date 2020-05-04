<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>RailWay</title>
    <link rel="icon" href="data:,">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js" type="text/javascript"></script>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel=”stylesheet”>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">

</head>
<style type="text/css">
    <%@include file="/WEB-INF/css/index.css"%>
</style>
<body>
<header>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="/">Navbar</a>

        <a href="?lang=en">EN</a>
        <a href="?lang=ua">UA</a>
    </nav>

</header>

<%--
<form action="${pageContext.request.contextPath}/login" method="post">
    <button>login</button>
</form>--%>


<h2>
    <fmt:message key="login.initial"/>
</h2>

<ul class="nav justify-content-center">
    <li class="nav-item">
        <a type="text/html" href="${pageContext.request.contextPath}/login">login</a>
    </li>
</ul>


<h1 class="rev-block">
    <span>Block Reveal</span>
</h1>
<h1 class="rev-block" id="onemore">
    <span>Block Project</span>
</h1>


<footer class="text-white bg-dark">
    <div id="footer" class="card-footer text-muted text-white bg-dark">© 2020 Copyright:All rights reserved</div>
</footer>


</body>
</html>
