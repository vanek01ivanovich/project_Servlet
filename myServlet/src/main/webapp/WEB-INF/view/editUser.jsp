<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 09.05.2020
  Time: 20:40
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

<form  method="post">
    <input type="text" name="userName" value="${user.getUserName()}">
    <c:if test="${validUserName == false}">
        user LOL
    </c:if>
    <br>
    <input type="text" name="firstName" value="${user.getFirstName()}">
    <c:if test="${validFirstName == false}">
        firstName LOL
    </c:if>
    <br>
    <input type="text" name="lastName" value="${user.getLastName()}">
    <c:if test="${validLastName == false}">
        lastName LOL
    </c:if>
    <br>
    <input type="text" name="ukrFirstName" value="${user.getFirstNameUkr()}">
    <c:if test="${validFirstNameUkr == false}">
        urk first LOL
    </c:if>
    <br>
    <input type="text" name="ukrLastName" value="${user.getLastNameUkr()}">
    <c:if test="${validLastNameUkr == false}">
        ukr first LOL
    </c:if>


    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <label class="input-group-text" for="inputGroupSelect01">Role</label>
        </div>
        <select name="role" class="custom-select" id="inputGroupSelect01">

            <c:if test="${user.getRole() == 'ROLE_USER'}">
                <option value="ROLE_USER" selected>USER</option>
                <option value="ROLE_ADMIN">ADMIN</option>
            </c:if>
            <c:if test="${user.getRole() == 'ROLE_ADMIN'}">
                <option value="ROLE_ADMIN" selected>ADMIN</option>
                <option value="ROLE_USER">USER</option>
            </c:if>
        </select>
    </div>


    <br>
    <button type="submit">submit</button>
</form>
<form action="/admin/allUsers">
    <button type="submit">back</button>
</form>

</body>
</html>
